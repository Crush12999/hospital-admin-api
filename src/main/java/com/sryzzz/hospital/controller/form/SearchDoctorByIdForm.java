package com.sryzzz.hospital.controller.form;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * 搜索医生表单实体
 *
 * @author sryzzz
 * @create 2022/11/20 23:24
 * @description 搜索医生表单实体
 */
@Data
public class SearchDoctorByIdForm {

    @NotNull(message = "id不能为空")
    @Min(value = 1, message = "id不能小于1")
    private Integer id;
}
