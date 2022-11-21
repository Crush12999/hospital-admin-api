package com.sryzzz.hospital.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sryzzz.hospital.common.PageUtils;
import com.sryzzz.hospital.db.entity.Doctor;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * 医生Service层
 *
 * @author sryzzz
 * @create 2022/11/14 20:52
 * @description 医生Service层
 */
public interface DoctorService extends IService<Doctor> {

    /**
     * 分页查询医生
     *
     * @param param 搜索条件
     * @return 医生分页信息
     */
    PageUtils searchByPage(Map<String, Object> param);

    /**
     * 查询医生详细信息
     *
     * @param id 医生id
     * @return 医生详细信息
     */
    HashMap<String, Object> searchContent(int id);

    /**
     * 更新医生照片
     *
     * @param file     照片
     * @param doctorId 医生id
     */
    void updatePhoto(MultipartFile file, Integer doctorId);

    /**
     * 添加医生信息
     *
     * @param param 医生信息
     */
    void insertDoctor(Map<String, Object> param);

    /**
     * 查询医生信息
     *
     * @param id 医生id
     * @return 医生信息
     */
    HashMap<String, Object> searchById(int id);

    /**
     * 更新医生信息
     *
     * @param param 医生信息
     */
    void updateDoctor(Map<String, Object> param);

    /**
     * 逻辑删除医生信息
     *
     * @param ids 待删除医生id列表
     */
    void deleteByIds(Integer[] ids);
}
