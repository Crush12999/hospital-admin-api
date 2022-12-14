package com.sryzzz.hospital.service;

import com.sryzzz.hospital.common.PageUtils;
import com.sryzzz.hospital.db.entity.MedicalDeptSub;

import java.util.HashMap;
import java.util.Map;

/**
 * 诊室Service层
 *
 * @author sryzzz
 * @create 2022/11/15 23:13
 * @description 诊室Service层
 */
public interface MedicalDeptSubService {

    /**
     * 分页查询诊室信息
     *
     * @param param 查询条件
     * @return 诊室分页记录
     */
    PageUtils searchByPage(Map<String, Object> param);

    /**
     * 添加诊室记录
     *
     * @param entity 诊室实体类
     */
    void insertMedicalDeptSub(MedicalDeptSub entity);

    /**
     * 查询简单的诊室信息
     *
     * @param id 诊室id
     * @return 诊室信息
     */
    HashMap<String, Object> searchById(int id);

    /**
     * 修改诊室信息
     *
     * @param entity 诊室实体类
     */
    void updateMedicalDeptSub(MedicalDeptSub entity);

    /**
     * 批量删除诊室
     *
     * @param ids 诊室id列表
     */
    void deleteByIds(Integer[] ids);
}
