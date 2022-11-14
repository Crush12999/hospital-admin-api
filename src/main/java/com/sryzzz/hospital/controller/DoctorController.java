package com.sryzzz.hospital.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.dev33.satoken.annotation.SaMode;
import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.api.R;
import com.sryzzz.hospital.common.PageUtils;
import com.sryzzz.hospital.common.ResponseResult;
import com.sryzzz.hospital.controller.form.SearchDoctorByPageForm;
import com.sryzzz.hospital.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Map;

/**
 * 医生模块相关接口
 *
 * @author sryzzz
 * @create 2022/11/14 20:59
 * @description 医生模块相关接口
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/doctor")
public class DoctorController {

    private final DoctorService doctorService;

    @PostMapping("/searchByPage")
    @SaCheckLogin
    @SaCheckPermission(value = {"ROOT", "DOCTOR:SELECT"}, mode = SaMode.OR)
    public ResponseResult searchByPage(@RequestBody @Valid SearchDoctorByPageForm form) {
        Map<String, Object> param = BeanUtil.beanToMap(form);
        int page = form.getPage();
        int length = form.getLength();
        int start = (page - 1) * length;
        param.put("start", start);
        PageUtils pageUtils = doctorService.searchByPage(param);
        return ResponseResult.ok().put("result", pageUtils);
    }
}
