package com.sryzzz.hospital.db.entity;

import lombok.Data;

/**
 * 医生工作计划任务
 *
 * @author sryzzz
 * @create 2022/11/12 13:40
 * @description 医生工作计划任务
 */
@Data
public class DoctorWorkPlanSchedule {
    private Integer id;
    private Integer workPlanId;
    private Integer slot;
    private Integer maximum;
    private Integer num;

}