package com.sryzzz.hospital.service.impl;

import cn.hutool.core.map.MapUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sryzzz.hospital.db.entity.MedicalDept;
import com.sryzzz.hospital.db.mapper.MedicalDeptMapper;
import com.sryzzz.hospital.service.MedicalDeptService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

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

    @Override
    public HashMap<String, Object> searchDeptAndSub() {
        ArrayList<HashMap<String, Object>> list = baseMapper.searchDeptAndSub();
        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        for (HashMap<String, Object> one : list) {
            Integer deptId = MapUtil.getInt(one, "deptId");
            Integer subId = MapUtil.getInt(one, "subId");
            String deptName = MapUtil.getStr(one, "deptName");
            String subName = MapUtil.getStr(one, "subName");
            if (map.containsKey(deptName)) {
                ArrayList<HashMap<String, Object>> subList = (ArrayList<HashMap<String, Object>>) map.get(deptName);
                subList.add(new HashMap<String, Object>() {{
                    put("subId", subId);
                    put("subName", subName);
                }});
            } else {
                map.put(deptName, new ArrayList<HashMap<String, Object>>() {{
                    add(new HashMap<String, Object>() {{
                        put("subId", subId);
                        put("subName", subName);
                    }});
                }});
            }
        }
        return map;
    }
}
