package com.sryzzz.hospital.db.entity;

import lombok.Data;

/**
 * 医生实体类
 *
 * @author sryzzz
 * @create 2022/11/12 13:40
 * @description 医生实体类
 */
@Data
public class Doctor {
    private Integer id;
    private String name;
    private String pid;
    private String uuid;
    private String sex;
    private String photo;
    private String birthday;
    private String school;
    private String degree;
    private String tel;
    private String address;
    private String email;
    private String job;
    private String remark;
    private String description;
    private String hiredate;
    private String tag;
    private Boolean recommended;
    private Byte status;
    private String createTime;

}