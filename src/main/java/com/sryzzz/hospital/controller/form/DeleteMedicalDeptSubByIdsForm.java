package com.sryzzz.hospital.controller.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * 删除诊室请求表单实体
 *
 * @author sryzzz
 * @create 2022/12/9 23:06
 * @description 删除诊室请求表单实体
 */
@Data
public class DeleteMedicalDeptSubByIdsForm {

    @NotEmpty(message = "ids不能为空")
    private Integer[] ids;

}
