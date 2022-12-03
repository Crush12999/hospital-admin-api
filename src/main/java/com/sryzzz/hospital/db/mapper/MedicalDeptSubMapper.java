package com.sryzzz.hospital.db.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sryzzz.hospital.db.entity.MedicalDeptSub;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * MedicalDeptSubMapper
 *
 * @author sryzzz
 * @create 2022/11/13 14:03
 * @description MedicalDeptSubMapper
 */
public interface MedicalDeptSubMapper extends BaseMapper<MedicalDeptSub> {
    /**
     * 分页查询诊室信息
     *
     * @param param 查询条件
     * @return 诊室分页记录
     */
    ArrayList<HashMap<String, Object>> searchByPage(Map<String, Object> param);

    /**
     * 查询诊室总数
     *
     * @param param 查询条件
     * @return 总记录数
     */
    long searchCount(Map<String, Object> param);
}




