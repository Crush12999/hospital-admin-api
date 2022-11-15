package com.sryzzz.hospital.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sryzzz.hospital.db.entity.MedicalDept;
import com.sryzzz.hospital.db.mapper.MedicalDeptMapper;
import com.sryzzz.hospital.service.MedicalDeptService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 科室Service层实现
 *
 * @author sryzzz
 * @create 2022/11/15 23:14
 * @description 科室Service层实现
 */
@Service
public class MedicalDeptServiceImpl extends ServiceImpl<MedicalDeptMapper, MedicalDept>
        implements MedicalDeptService {

    @Override
    public ArrayList<HashMap<String, Object>> searchAll() {
        return baseMapper.searchAll();
    }
}
