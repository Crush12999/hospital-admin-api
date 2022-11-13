package com.sryzzz.hospital.db.entity;

import lombok.Data;

/**
 * 医疗部门
 *
 * @author sryzzz
 * @create 2022/11/12 13:40
 * @description 医疗部门
 */
@Data
public class MedicalDept {
    private Integer id;
    private String name;
    private Boolean outpatient;
    private String description;
    private Boolean recommended;
}