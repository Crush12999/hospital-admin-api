package com.sryzzz.hospital.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sryzzz.hospital.common.PageUtils;
import com.sryzzz.hospital.db.entity.Doctor;

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
}