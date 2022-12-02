package com.sryzzz.hospital.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sryzzz.hospital.common.PageUtils;
import com.sryzzz.hospital.db.entity.MedicalDept;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 科室Service层
 *
 * @author sryzzz
 * @create 2022/11/15 23:13
 * @description 科室Service层
 */
public interface MedicalDeptService extends IService<MedicalDept> {

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
    HashMap<String, Object> searchDeptAndSub();

    /**
     * 分页查询科室记录
     *
     * @param param 查询条件
     * @return 科室记录
     */
    PageUtils searchByPage(Map<String, Object> param);

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

    /**
     * 删除科室信息
     *
     * @param ids 科室ids
     */
    void deleteByIds(Integer[] ids);
}
