package com.sryzzz.hospital.db.entity;

import lombok.Data;

/**
 * 医疗部门子部门-医生关联
 *
 * @author sryzzz
 * @create 2022/11/12 13:40
 * @description 医疗部门子部门-医生关联
 */
@Data
public class MedicalDeptSubAndDoctor {
    private Integer id;
    private Integer deptSubId;
    private Integer doctorId;

}