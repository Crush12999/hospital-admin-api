package com.sryzzz.hospital.db.entity;

import lombok.Data;

/**
 * 医疗诊室-医生关联
 *
 * @author sryzzz
 * @create 2022/11/12 13:40
 * @description 记录医生隶属于哪个诊室
 */
@Data
public class MedicalDeptSubAndDoctor {

    /**
     * 主键
     */
    private Integer id;

    /**
     * 诊室ID
     */
    private Integer deptSubId;

    /**
     * 医生ID
     */
    private Integer doctorId;

}