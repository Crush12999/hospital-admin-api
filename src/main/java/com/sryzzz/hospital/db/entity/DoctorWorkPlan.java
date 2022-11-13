package com.sryzzz.hospital.db.entity;

import lombok.Data;

/**
 * 医生工作计划
 *
 * @author sryzzz
 * @create 2022/11/12 13:40
 * @description 医生工作计划
 */
@Data
public class DoctorWorkPlan {
    private Integer id;
    private Integer doctorId;
    private Integer deptSubId;
    private String date;
    private Integer maximum;
    private Integer num;

}