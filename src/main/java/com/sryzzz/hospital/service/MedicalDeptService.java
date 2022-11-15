package com.sryzzz.hospital.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sryzzz.hospital.db.entity.MedicalDept;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 科室Service层
 *
 * @author sryzzz
 * @create 2022/11/15 23:13
 * @description 科室Service层
 */
public interface MedicalDeptService extends IService<MedicalDept> {

    /**
     * 查询所有科室
     *
     * @return 所有科室信息
     */
    ArrayList<HashMap<String, Object>> searchAll();
}
