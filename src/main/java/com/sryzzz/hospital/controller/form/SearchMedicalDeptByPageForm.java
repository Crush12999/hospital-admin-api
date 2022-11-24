package com.sryzzz.hospital.controller.form;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * 科室搜索条件实体
 *
 * @author sryzzz
 * @create 2022/11/24 23:51
 * @description 科室搜索条件实体
 */
@Data
public class SearchMedicalDeptByPageForm {

    @Pattern(regexp = "^[a-zA-Z0-9\\u4e00-\\u9fa5]{1,50}$", message = "name内容不正确")
    private String name;

    private Boolean outpatient;

    private Boolean recommended;

    @NotNull(message = "page不能为空")
    @Min(value = 1, message = "page不能小于1")
    private Integer page;

    @NotNull(message = "length不能为空")
    @Range(min = 10, max = 50, message = "length内容不正确")
    private Integer length;

}
