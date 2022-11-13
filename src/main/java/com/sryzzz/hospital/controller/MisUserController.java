package com.sryzzz.hospital.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.bean.BeanUtil;
import com.sryzzz.hospital.common.ResponseResult;
import com.sryzzz.hospital.controller.form.LoginForm;
import com.sryzzz.hospital.service.MisUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * MIS系统用户模块接口
 *
 * @author sryzzz
 * @create 2022/11/13 18:02
 * @description MIS系统用户模块接口
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/mis_user")
public class MisUserController {

    private final MisUserService misUserService;

    /**
     * 登录
     */
    @PostMapping("/login")
    public ResponseResult login(@RequestBody @Valid LoginForm form) {
        Map<String, Object> param = BeanUtil.beanToMap(form);
        Integer userId = misUserService.login(param);
        if (userId != null) {
            StpUtil.login(userId);
            String token = StpUtil.getTokenValue();
            List<String> permissions = StpUtil.getPermissionList();
            return ResponseResult.ok()
                    .put("result", true)
                    .put("token", token)
                    .put("permissions", permissions);

        }
        return ResponseResult.ok().put("result", false);

    }

    /**
     * 注销
     */
    @GetMapping("/logout")
    @SaCheckLogin
    public ResponseResult logout() {
        StpUtil.logout();
        return ResponseResult.ok();
    }
}
