package com.sryzzz.hospital.service.impl;

import cn.hutool.core.map.MapUtil;
import com.sryzzz.hospital.common.PageUtils;
import com.sryzzz.hospital.db.mapper.MedicalDeptSubMapper;
import com.sryzzz.hospital.service.MedicalDeptSubService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 诊室Service层实现
 *
 * @author sryzzz
 * @create 2022/11/15 23:14
 * @description 诊室Service层实现
 */
@RequiredArgsConstructor
@Service
public class MedicalDeptSubServiceImpl implements MedicalDeptSubService {

    private final MedicalDeptSubMapper medicalDeptSubMapper;

    @Override
    public PageUtils searchByPage(Map<String, Object> param) {
        ArrayList<HashMap<String, Object>> list = null;
        long count = medicalDeptSubMapper.searchCount(param);
        if (count > 0) {
            list = medicalDeptSubMapper.searchByPage(param);
        } else {
            list = new ArrayList<>();
        }
        int page = MapUtil.getInt(param, "page");
        int length = MapUtil.getInt(param, "length");
        return new PageUtils(list, count, page, length);
    }
}
