package com.sryzzz.hospital.controller.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * 添加科室记录表单
 *
 * @author sryzzz
 * @create 2022/11/25 23:55
 * @description 添加科室记录表单
 */
@Data
public class InsertMedicalDeptForm {

    @NotBlank(message = "name不能为空")
    @Pattern(regexp = "^[a-zA-Z0-9\\u4e00-\\u9fa5]{2,10}$",message = "name内容不正确")
    private String name;

    @NotNull(message = "outpatient不能为空")
    private Boolean outpatient;

    @NotNull(message = "recommended不能为空")
    private Boolean recommended;

    @NotNull(message = "description不能为空")
    private String description;
}
