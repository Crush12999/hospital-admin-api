package com.sryzzz.hospital.db.entity;

import lombok.Data;

/**
 * 诊室数据表
 *
 * @author sryzzz
 * @create 2022/11/12 13:40
 * @description 诊室数据表，诊室隶属于科室，比如胸外科诊室就隶属于外科，神经内科诊室隶属于内科。
 */
@Data
public class MedicalDeptSub {

    /**
     * 主键
     */
    private Integer id;

    /**
     * 诊室名称
     */
    private String name;

    /**
     * 隶属科室ID
     */
    private Integer deptId;

    /**
     * 诊室位置
     */
    private String location;
}