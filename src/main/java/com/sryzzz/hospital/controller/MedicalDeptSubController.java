package com.sryzzz.hospital.controller;

import cn.hutool.core.bean.BeanUtil;
import com.sryzzz.hospital.common.PageUtils;
import com.sryzzz.hospital.common.ResponseResult;
import com.sryzzz.hospital.controller.form.SearchMedicalDeptSubByPageForm;
import com.sryzzz.hospital.service.MedicalDeptSubService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
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

    public ResponseResult searchByPage(@RequestBody @Valid SearchMedicalDeptSubByPageForm form) {
        Map<String, Object> param = BeanUtil.beanToMap(form);
        int page = form.getPage();
        int length = form.getLength();
        int start = (page - 1) * length;
        param.put("start", start);
        PageUtils pageUtils = medicalDeptSubService.searchByPage(param);
        return ResponseResult.ok().put("result", pageUtils);
    }

}
