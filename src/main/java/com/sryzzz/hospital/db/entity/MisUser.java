package com.sryzzz.hospital.db.entity;

import lombok.Data;

/**
 * web管理端用户
 *
 * @author sryzzz
 * @create 2022/11/12 13:40
 * @description web管理端用户
 */
@Data
public class MisUser {
    private Integer id;
    private String username;
    private String password;
    private String name;
    private String sex;
    private String tel;
    private String email;
    private Integer deptId;
    private String job;
    private Integer refId;
    private Byte status;
    private String createTime;
}