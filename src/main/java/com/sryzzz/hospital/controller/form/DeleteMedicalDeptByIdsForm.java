package com.sryzzz.hospital.controller.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * 删除科室表单实体
 *
 * @author sryzzz
 * @create 2022/12/2 23:33
 * @description 删除科室表单实体
 */

@Data
public class DeleteMedicalDeptByIdsForm {

    @NotEmpty(message = "ids不能为空")
    private Integer[] ids;
}
