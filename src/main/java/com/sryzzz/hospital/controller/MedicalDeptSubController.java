package com.sryzzz.hospital.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.dev33.satoken.annotation.SaMode;
import cn.hutool.core.bean.BeanUtil;
import com.sryzzz.hospital.common.PageUtils;
import com.sryzzz.hospital.common.ResponseResult;
import com.sryzzz.hospital.controller.form.*;
import com.sryzzz.hospital.db.entity.MedicalDeptSub;
import com.sryzzz.hospital.service.MedicalDeptSubService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * 诊室相关接口
 *
 * @author sryzzz
 * @create 2022/12/3 23:36
 * @description 诊室相关接口
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/medical/dept/sub")
public class MedicalDeptSubController {

    private final MedicalDeptSubService medicalDeptSubService;

    @PostMapping("/searchByPage")
    @SaCheckLogin
    @SaCheckPermission(value = {"ROOT", "MEDICAL_DEPT_SUB:SELECT"}, mode = SaMode.OR)
    public ResponseResult searchByPage(@RequestBody @Valid SearchMedicalDeptSubByPageForm form) {
        Map<String, Object> param = BeanUtil.beanToMap(form);
        int page = form.getPage();
        int length = form.getLength();
        int start = (page - 1) * length;
        param.put("start", start);
        PageUtils pageUtils = medicalDeptSubService.searchByPage(param);
        return ResponseResult.ok().put("result", pageUtils);
    }

    @PostMapping("/insert")
    @SaCheckLogin
    @SaCheckPermission(value = {"ROOT", "MEDICAL_DEPT_SUB:INSERT"}, mode = SaMode.OR)
    public ResponseResult insert(@RequestBody @Valid InsertMedicalDeptSubForm form) {
        MedicalDeptSub entity = BeanUtil.toBean(form, MedicalDeptSub.class);
        medicalDeptSubService.insertMedicalDeptSub(entity);
        return ResponseResult.ok();
    }

    @PostMapping("/searchById")
    @SaCheckLogin
    @SaCheckPermission(value = {"ROOT", "MEDICAL_DEPT_SUB:SELECT"}, mode = SaMode.OR)
    public ResponseResult searchById(@RequestBody @Valid SearchMedicalDeptSubByIdForm form) {
        HashMap<String, Object> map = medicalDeptSubService.searchById(form.getId());
        return ResponseResult.ok(map);
    }

    @PostMapping("/update")
    @SaCheckLogin
    @SaCheckPermission(value = {"ROOT", "MEDICAL_DEPT_SUB:UPDATE"}, mode = SaMode.OR)
    public ResponseResult update(@RequestBody @Valid UpdateMedicalDeptSubForm form) {
        MedicalDeptSub entity = BeanUtil.toBean(form, MedicalDeptSub.class);
        medicalDeptSubService.updateMedicalDeptSub(entity);
        return ResponseResult.ok();
    }

    @PostMapping("/deleteByIds")
    @SaCheckLogin
    @SaCheckPermission(value = {"ROOT", "MEDICAL_DEPT_SUB:DELETE"}, mode = SaMode.OR)
    public ResponseResult deleteByIds(@RequestBody @Valid DeleteMedicalDeptSubByIdsForm form) {
        medicalDeptSubService.deleteByIds(form.getIds());
        return ResponseResult.ok();
    }
}
