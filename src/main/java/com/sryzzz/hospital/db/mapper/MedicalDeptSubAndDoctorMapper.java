package com.sryzzz.hospital.db.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sryzzz.hospital.db.entity.MedicalDeptSubAndDoctor;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * MedicalDeptSubAndDoctorMapper
 *
 * @author sryzzz
 * @create 2022/11/13 14:03
 * @description MedicalDeptSubAndDoctorMapper
 */
public interface MedicalDeptSubAndDoctorMapper extends BaseMapper<MedicalDeptSubAndDoctor> {

    /**
     * 保存医生和科室的隶属关系
     *
     * @param entity 相关信息
     */
    @Transactional(rollbackFor = Exception.class)
    void insertMedicalDeptSubAndDoctor(MedicalDeptSubAndDoctor entity);

    /**
     * 更新医生和科室的隶属关系
     *
     * @param param 医生和科室的隶属关系
     */
    void updateDoctorSubDept(Map<String, Object> param);
}




