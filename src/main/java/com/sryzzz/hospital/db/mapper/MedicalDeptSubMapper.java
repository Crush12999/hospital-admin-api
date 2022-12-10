package com.sryzzz.hospital.db.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sryzzz.hospital.db.entity.MedicalDeptSub;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * MedicalDeptSubMapper
 *
 * @author sryzzz
 * @create 2022/11/13 14:03
 * @description MedicalDeptSubMapper
 */
public interface MedicalDeptSubMapper extends BaseMapper<MedicalDeptSub> {
    /**
     * 分页查询诊室信息
     *
     * @param param 查询条件
     * @return 诊室分页记录
     */
    ArrayList<HashMap<String, Object>> searchByPage(Map<String, Object> param);

    /**
     * 查询诊室总数
     *
     * @param param 查询条件
     * @return 总记录数
     */
    long searchCount(Map<String, Object> param);

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
     * 获得诊室下的医生总数
     *
     * @param ids 诊室ids
     * @return 诊室下的医生总数
     */
    long searchDoctorCount(Integer[] ids);

    /**
     * 批量删除诊室
     *
     * @param ids 诊室id列表
     */
    void deleteByIds(Integer[] ids);
}




