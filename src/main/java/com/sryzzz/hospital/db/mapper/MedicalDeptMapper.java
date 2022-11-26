package com.sryzzz.hospital.db.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sryzzz.hospital.db.entity.MedicalDept;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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

    /**
     * 分页查询科室记录
     *
     * @param param 查询条件
     * @return 科室记录
     */
    ArrayList<HashMap<String, Object>> searchByPage(Map<String, Object> param);

    /**
     * 查询总记录数
     *
     * @param param 查询条件
     * @return 总记录数
     */
    long searchCount(Map<String, Object> param);

    /**
     * 添加科室记录
     *
     * @param entity 科室记录
     */
    void insertMedicalDept(MedicalDept entity);

    /**
     * 通过id查询科室信息
     *
     * @param id 科室id
     * @return 科室信息
     */
    HashMap<String, Object> searchById(int id);

    /**
     * 更新科室信息
     *
     * @param entity 科室信息
     */
    void updateMedicalDept(MedicalDept entity);
}




