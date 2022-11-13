package com.sryzzz.hospital.controller.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * 登录表单实体
 *
 * @author sryzzz
 * @create 2022/11/13 18:01
 * @description 登录表单实体
 */
@Data
public class LoginForm {

    @NotBlank(message = "username不能为空")
    @Pattern(regexp = "^[a-zA-Z0-9]{5,50}$", message = "username内容不正确")
    private String username;

    @NotBlank(message = "password不能为空")
    @Pattern(regexp = "^[a-zA-Z0-9]{6,20}$", message = "password内容不正确")
    private String password;
}

