package com.sryzzz.hospital.controller.form;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * 单个诊室查询表单实体
 *
 * @author sryzzz
 * @create 2022/12/9 00:00
 * @description 单个诊室查询表单实体
 */
@Data
public class SearchMedicalDeptSubByIdForm {

    @NotNull(message = "id不能为空")
    @Min(value = 1, message = "id不能小于1")
    private Integer id;
}
