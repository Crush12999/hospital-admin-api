package com.sryzzz.hospital.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sryzzz.hospital.common.PageUtils;
import com.sryzzz.hospital.db.entity.Doctor;
import com.sryzzz.hospital.db.entity.MedicalDeptSubAndDoctor;
import com.sryzzz.hospital.db.mapper.DoctorMapper;
import com.sryzzz.hospital.db.mapper.MedicalDeptSubAndDoctorMapper;
import com.sryzzz.hospital.exception.HospitalException;
import com.sryzzz.hospital.service.DoctorService;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 医生Service层实现
 *
 * @author sryzzz
 * @create 2022/11/14 20:54
 * @description 医生Service层实现
 */
@RequiredArgsConstructor
@Service
public class DoctorServiceImpl extends ServiceImpl<DoctorMapper, Doctor>
        implements DoctorService {

    private MedicalDeptSubAndDoctorMapper medicalDeptSubAndDoctorMapper;

    @Value("${minio.endpoint}")
    private String endpoint;

    @Value("${minio.access-key}")
    private String accessKey;

    @Value("${minio.secret-key}")
    private String secretKey;

    @Override
    public PageUtils searchByPage(Map<String, Object> param) {
        ArrayList<HashMap<String, Object>> list = null;
        long count = baseMapper.searchCount(param);
        if (count > 0) {
            list = baseMapper.searchByPage(param);
        } else {
            list = new ArrayList<>();
        }
        int page = MapUtil.getInt(param, "page");
        int length = MapUtil.getInt(param, "length");
        return new PageUtils(list, count, page, length);
    }

    @Override
    public HashMap<String, Object> searchContent(int id) {
        HashMap<String, Object> map = baseMapper.searchContent(id);
        JSONArray tag = JSONUtil.parseArray(MapUtil.getStr(map, "tag"));
        map.replace("tag", tag);
        return map;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updatePhoto(MultipartFile file, Integer doctorId) {
        try {
            String filename = "doctor-" + doctorId + ".jpg";
            //在Minio中保存医生照片
            MinioClient client = new MinioClient.Builder().endpoint(endpoint)
                    .credentials(accessKey, secretKey).build();

            client.putObject(PutObjectArgs.builder().bucket("hospital")
                    .object("doctor/" + filename)
                    .stream(file.getInputStream(), -1, 5 * 1024 * 1024)
                    .contentType("image/jpeg").build());

            //更新医生表photo字段
            baseMapper.updatePhoto(new HashMap<String, Object>(16) {{
                put("id", doctorId);
                put("photo", "/doctor/" + filename);
            }});
        } catch (Exception e) {
            log.error("保存医生照片失败", e);
            throw new HospitalException("保存医生照片失败");
        }
    }

    @Override
    public void insertDoctor(Map<String, Object> param) {
        // 保存医生记录
        Doctor doctor = BeanUtil.toBean(param, Doctor.class);
        baseMapper.insertDoctor(doctor);

        // 根据uuid查询医生主键值
        String uuid = doctor.getUuid();
        Integer doctorId = baseMapper.searchIdByUuid(uuid);

        // 保存医生诊室记录
        int subId = MapUtil.getInt(param, "subId");
        MedicalDeptSubAndDoctor entity2 = new MedicalDeptSubAndDoctor();
        entity2.setDeptSubId(subId);
        entity2.setDoctorId(doctorId);
        medicalDeptSubAndDoctorMapper.insert(entity2);
    }
}
