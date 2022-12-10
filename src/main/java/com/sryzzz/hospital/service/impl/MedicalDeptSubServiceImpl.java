package com.sryzzz.hospital.service.impl;

import cn.hutool.core.map.MapUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sryzzz.hospital.common.PageUtils;
import com.sryzzz.hospital.db.entity.MedicalDeptSub;
import com.sryzzz.hospital.db.mapper.MedicalDeptSubMapper;
import com.sryzzz.hospital.exception.HospitalException;
import com.sryzzz.hospital.service.MedicalDeptSubService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 诊室Service层实现
 *
 * @author sryzzz
 * @create 2022/11/15 23:14
 * @description 诊室Service层实现
 */
@Service
public class MedicalDeptSubServiceImpl extends ServiceImpl<MedicalDeptSubMapper, MedicalDeptSub>
        implements MedicalDeptSubService {

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

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void insertMedicalDeptSub(MedicalDeptSub entity) {
        baseMapper.insertMedicalDeptSub(entity);
    }

    @Override
    public HashMap<String, Object> searchById(int id) {
        return baseMapper.searchById(id);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateMedicalDeptSub(MedicalDeptSub entity) {
        baseMapper.updateMedicalDeptSub(entity);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteByIds(Integer[] ids) {
        long count = baseMapper.searchDoctorCount(ids);
        if (count == 0) {
            baseMapper.deleteByIds(ids);
        } else {
            throw new HospitalException("诊室存在关联医生，无法删除记录");
        }
    }
}
