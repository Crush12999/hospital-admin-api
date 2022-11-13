package com.sryzzz.hospital.db.entity;

import lombok.Data;

/**
 * MIS系统的用户表
 *
 * @author sryzzz
 * @create 2022/11/12 13:40
 * @description MIS系统的用户表
 */
@Data
public class MisUser {

    /**
     * 主键
     */
    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 姓名
     */
    private String name;

    /**
     * 性别
     */
    private String sex;

    /**
     * 电话（用于接收重置密码的短信验证码）
     */
    private String tel;

    /**
     * 邮箱（用于接收重置密码的邮件验证码）
     */
    private String email;

    /**
     * 隶属的部门ID
     */
    private Integer deptId;

    /**
     * 职务（医生、护士等）
     */
    private String job;

    /**
     * 关联ID（例如医生ID，护士ID等）
     */
    private Integer refId;

    /**
     * 1有效，2离职，3禁用
     */
    private Byte status;

    /**
     * 创建日期
     */
    private String createTime;
}