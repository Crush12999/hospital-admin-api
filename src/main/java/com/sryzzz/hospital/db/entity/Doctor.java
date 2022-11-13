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

    /**
     * 主键
     */
    private Integer id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 身份证号
     */
    private String pid;

    /**
     * UUID（用于在工牌上印刷二维码）
     */
    private String uuid;

    /**
     * 性别
     */
    private String sex;

    /**
     * 照片地址
     */
    private String photo;

    /**
     * 生日
     */
    private String birthday;

    /**
     * 毕业院校
     */
    private String school;

    /**
     * 学位
     */
    private String degree;

    /**
     * 电话
     */
    private String tel;

    /**
     * 家庭住址
     */
    private String address;

    /**
     * 电子邮箱
     */
    private String email;

    /**
     * 职务（主任医师、副主任医师等）
     */
    private String job;

    /**
     * 备注
     */
    private String remark;

    /**
     * 详细介绍
     */
    private String description;

    /**
     * 入职日期
     */
    private String hiredate;

    /**
     * 特点标签（小程序上用到）
     */
    private String tag;

    /**
     * 是否在小程序上推荐
     */
    private Boolean recommended;

    /**
     * 1在职，2离职，3退休，4隐藏（逻辑删除）
     */
    private Byte status;

    /**
     * 添加时间
     */
    private String createTime;

}