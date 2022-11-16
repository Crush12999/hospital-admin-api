package com.sryzzz.hospital.db.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sryzzz.hospital.db.entity.Doctor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * DoctorMapper
 *
 * @author sryzzz
 * @create 2022/11/13 14:03
 * @description DoctorMapper
 */
public interface DoctorMapper extends BaseMapper<Doctor> {

    /**
     * 查询某页记录
     *
     * @param param 查询条件
     * @return 某页记录
     */
    ArrayList<HashMap<String, Object>> searchByPage(Map<String, Object> param);

    /**
     * 查询记录总数
     *
     * @param param 查询条件
     * @return 记录总数
     */
    long searchCount(Map<String, Object> param);

    /**
     * 查询医生详细信息
     *
     * @param id 医生id
     * @return 医生详细信息
     */
    HashMap<String, Object> searchContent(int id);
}




