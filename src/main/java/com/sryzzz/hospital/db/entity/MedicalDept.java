package com.sryzzz.hospital.db.entity;

import lombok.Data;

/**
 * 医疗科室表
 *
 * @author sryzzz
 * @create 2022/11/12 13:40
 * @description 医疗科室表，比如内科、外科、肿瘤科这种大的科室。
 */
@Data
public class MedicalDept {

    /**
     * 主键
     */
    private Integer id;

    /**
     * 科室名称
     */
    private String name;

    /**
     * 是否为门诊（例如放射线科就不是门诊）
     */
    private Boolean outpatient;

    /**
     * 详细介绍
     */
    private String description;

    /**
     * 是否为推荐科室（小程序上用到）
     */
    private Boolean recommended;
}