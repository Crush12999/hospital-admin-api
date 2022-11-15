package com.sryzzz.hospital.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import com.sryzzz.hospital.common.ResponseResult;
import com.sryzzz.hospital.service.MedicalDeptService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 科室相关接口
 *
 * @author sryzzz
 * @create 2022/11/15 23:15
 * @description 科室相关接口
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/medical/dept")
public class MedicalDeptController {

    private final MedicalDeptService medicalDeptService;

    @GetMapping("/searchAll")
    @SaCheckLogin
    public ResponseResult searchAll() {
        ArrayList<HashMap<String, Object>> list = medicalDeptService.searchAll();
        return ResponseResult.ok().put("result", list);
    }
}
