package com.sryzzz.hospital.controller.form;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * 查询医生详细信息搜索条件的表单
 *
 * @author sryzzz
 * @create 2022/11/16 23:16
 * @description 查询医生详细信息搜索条件的表单
 */
@Data
public class SearchDoctorContentForm {

    @NotNull(message = "id不能为空")
    @Min(value = 1, message = "id不能小于1")
    private Integer id;
}
