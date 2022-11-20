package com.sryzzz.hospital.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.dev33.satoken.annotation.SaMode;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.json.JSONUtil;
import com.sryzzz.hospital.common.PageUtils;
import com.sryzzz.hospital.common.ResponseResult;
import com.sryzzz.hospital.controller.form.*;
import com.sryzzz.hospital.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.HashMap;
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

    /**
     * 查询医生详细信息
     */
    @PostMapping("/searchContent")
    @SaCheckLogin
    @SaCheckPermission(value = {"ROOT", "DOCTOR:SELECT"}, mode = SaMode.OR)
    public ResponseResult searchContent(@RequestBody @Valid SearchDoctorContentForm form) {
        HashMap<String, Object> map = doctorService.searchContent(form.getId());
        return ResponseResult.ok(map);
    }

    /**
     * 更新医生照片
     *
     * @param file     照片
     * @param doctorId 医生id
     */
    @PostMapping("/updatePhoto")
    @SaCheckLogin
    @SaCheckPermission(value = {"ROOT", "DOCTOR:UPDATE"}, mode = SaMode.OR)
    public ResponseResult updatePhoto(@Param("file") MultipartFile file, @Param("doctorId") Integer doctorId) {
        doctorService.updatePhoto(file, doctorId);
        return ResponseResult.ok();
    }

    /**
     * 添加医生
     */
    @PostMapping("/insert")
    @SaCheckLogin
    @SaCheckPermission(value = {"ROOT", "DOCTOR:INSERT"}, mode = SaMode.OR)
    public ResponseResult insertDoctor(@RequestBody @Valid InsertDoctorForm form) {
        Map<String, Object> param = BeanUtil.beanToMap(form);
        String json = JSONUtil.parseArray(form.getTag()).toString();
        param.replace("tag", json);
        param.put("uuid", IdUtil.simpleUUID().toUpperCase());
        doctorService.insertDoctor(param);
        return ResponseResult.ok();
    }

    @PostMapping("/searchById")
    @SaCheckLogin
    @SaCheckPermission(value = {"ROOT", "DOCTOR:SELECT"}, mode = SaMode.OR)
    public ResponseResult searchById(@RequestBody @Valid SearchDoctorByIdForm form) {
        HashMap<String, Object> map = doctorService.searchById(form.getId());
        return ResponseResult.ok(map);
    }

    @PostMapping("/update")
    @SaCheckLogin
    @SaCheckPermission(value = {"ROOT", "DOCTOR:UPDATE"}, mode = SaMode.OR)
    public ResponseResult update(@RequestBody @Valid UpdateDoctorForm form) {
        Map<String, Object> param = BeanUtil.beanToMap(form);
        String json = JSONUtil.parseArray(form.getTag()).toString();
        param.replace("tag", json);
        doctorService.updateDoctor(param);
        return ResponseResult.ok();
    }
}
