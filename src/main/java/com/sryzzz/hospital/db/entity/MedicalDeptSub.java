package com.sryzzz.hospital.db.entity;

import lombok.Data;

/**
 * 医疗部门子部门
 *
 * @author sryzzz
 * @create 2022/11/12 13:40
 * @description 医疗部门子部门
 */
@Data
public class MedicalDeptSub {
    private Integer id;
    private String name;
    private Integer deptId;
    private String location;
}