package com.sryzzz.hospital.service;

import com.sryzzz.hospital.common.PageUtils;

import java.util.Map;

/**
 * 诊室Service层
 *
 * @author sryzzz
 * @create 2022/11/15 23:13
 * @description 诊室Service层
 */
public interface MedicalDeptSubService {

    /**
     * 分页查询诊室信息
     *
     * @param param 查询条件
     * @return 诊室分页记录
     */
    PageUtils searchByPage(Map<String, Object> param);
}
