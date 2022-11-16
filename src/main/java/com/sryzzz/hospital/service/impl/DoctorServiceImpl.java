package com.sryzzz.hospital.service.impl;

import cn.hutool.core.map.MapUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sryzzz.hospital.common.PageUtils;
import com.sryzzz.hospital.db.entity.Doctor;
import com.sryzzz.hospital.db.mapper.DoctorMapper;
import com.sryzzz.hospital.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 医生Service层实现
 *
 * @author sryzzz
 * @create 2022/11/14 20:54
 * @description 医生Service层实现
 */
@RequiredArgsConstructor
@Service
public class DoctorServiceImpl extends ServiceImpl<DoctorMapper, Doctor>
        implements DoctorService {

    @Override
    public PageUtils searchByPage(Map<String, Object> param) {
        ArrayList<HashMap<String, Object>> list = null;
        long count = baseMapper.searchCount(param);
        if (count > 0) {
            list = baseMapper.searchByPage(param);
        } else {
            list = new ArrayList<>();
        }
        int page = MapUtil.getInt(param, "page");
        int length = MapUtil.getInt(param, "length");
        return new PageUtils(list, count, page, length);
    }

    @Override
    public HashMap<String, Object> searchContent(int id) {
        HashMap<String, Object> map = baseMapper.searchContent(id);
        JSONArray tag = JSONUtil.parseArray(MapUtil.getStr(map, "tag"));
        map.replace("tag", tag);
        return map;
    }
}
