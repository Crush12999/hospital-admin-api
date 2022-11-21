package com.sryzzz.hospital.controller.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * 删除医生请求表单
 *
 * @author sryzzz
 * @create 2022/11/21 22:49
 * @description 删除医生请求表单
 */
@Data
public class DeleteDoctorByIdsForm {

    @NotEmpty(message = "ids不能为空")
    private Integer[] ids;

}
