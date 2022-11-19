package com.sryzzz.hospital.db.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sryzzz.hospital.db.entity.MedicalDept;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * MedicalDeptMapper
 *
 * @author sryzzz
 * @create 2022/11/13 14:03
 * @description MedicalDeptMapper
 */
public interface MedicalDeptMapper extends BaseMapper<MedicalDept> {

    /**
     * 查询所有科室
     *
     * @return 所有科室信息
     */
    ArrayList<HashMap<String, Object>> searchAll();

    /**
     * 查询科室 & 诊室列表
     *
     * @return 科室 & 诊室列表
     */
    ArrayList<HashMap<String, Object>> searchDeptAndSub();

}




