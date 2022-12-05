package com.sryzzz.hospital.controller.form;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * 添加诊室表单实体
 *
 * @author sryzzz
 * @create 2022/12/5 22:47
 * @description 添加诊室表单实体
 */
@Data
public class InsertMedicalDeptSubForm {

    @NotBlank(message = "name不能为空")
    @Pattern(regexp = "^[a-zA-Z0-9\\u4e00-\\u9fa5]{2,10}$", message = "name内容不正确")
    private String name;

    @NotNull(message = "deptId不能为空")
    @Min(value = 1, message = "deptId不能小于1")
    private Integer deptId;

    @NotBlank(message = "location不能为空")
    private String location;

}
