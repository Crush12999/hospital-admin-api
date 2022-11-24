package com.sryzzz.hospital.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.dev33.satoken.annotation.SaMode;
import cn.hutool.core.bean.BeanUtil;
import com.sryzzz.hospital.common.PageUtils;
import com.sryzzz.hospital.common.ResponseResult;
import com.sryzzz.hospital.controller.form.SearchMedicalDeptByPageForm;
import com.sryzzz.hospital.service.MedicalDeptService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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

    /**
     * 查询科室 & 诊室列表
     */
    @GetMapping("/searchDeptAndSub")
    @SaCheckLogin
    public ResponseResult searchDeptAndSub() {
        HashMap<String, Object> map = medicalDeptService.searchDeptAndSub();
        return ResponseResult.ok().put("result", map);
    }

    @PostMapping("/searchByPage")
    @SaCheckLogin
    @SaCheckPermission(value = {"ROOT", "MEDICAL_DEPT:SELECT"}, mode = SaMode.OR)
    public ResponseResult searchByPage(@RequestBody @Valid SearchMedicalDeptByPageForm form) {
        Map<String, Object> param = BeanUtil.beanToMap(form);
        int page = form.getPage();
        int length = form.getLength();
        int start = (page - 1) * length;
        param.put("start", start);
        PageUtils pageUtils = medicalDeptService.searchByPage(param);
        return ResponseResult.ok().put("result", pageUtils);
    }
}
