package com.sryzzz.hospital.db.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sryzzz.hospital.db.entity.MedicalDeptSubAndDoctor;
import org.springframework.transaction.annotation.Transactional;

/**
 * MedicalDeptSubAndDoctorMapper
 *
 * @author sryzzz
 * @create 2022/11/13 14:03
 * @description MedicalDeptSubAndDoctorMapper
 */
public interface MedicalDeptSubAndDoctorMapper extends BaseMapper<MedicalDeptSubAndDoctor> {

    /**
     * 保存医生和诊治的隶属关系
     *
     * @param entity 相关信息
     */
    @Transactional(rollbackFor = Exception.class)
    void insertMedicalDeptSubAndDoctor(MedicalDeptSubAndDoctor entity);
}




