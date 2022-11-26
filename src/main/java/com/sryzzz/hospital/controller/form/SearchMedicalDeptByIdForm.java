package com.sryzzz.hospital.controller.form;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * 科室搜索表单
 *
 * @author sryzzz
 * @create 2022/11/26 23:51
 * @description 科室搜索表单
 */
@Data
public class SearchMedicalDeptByIdForm {

    @NotNull(message = "id不能为空")
    @Min(value = 1, message = "id不能小于1")
    private Integer id;
}
