package com.sryzzz.hospital.db.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sryzzz.hospital.db.entity.Doctor;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * DoctorMapper
 *
 * @author sryzzz
 * @create 2022/11/13 14:03
 * @description DoctorMapper
 */
public interface DoctorMapper extends BaseMapper<Doctor> {

    /**
     * 查询某页记录
     *
     * @param param 查询条件
     * @return 某页记录
     */
    ArrayList<HashMap<String, Object>> searchByPage(Map<String, Object> param);

    /**
     * 查询记录总数
     *
     * @param param 查询条件
     * @return 记录总数
     */
    long searchCount(Map<String, Object> param);

    /**
     * 查询医生详细信息
     *
     * @param id 医生id
     * @return 医生详细信息
     */
    HashMap<String, Object> searchContent(int id);

    /**
     * 更新医生照片
     *
     * @param param 相关参数
     */
    void updatePhoto(Map<String, Object> param);

    /**
     * 添加医生
     *
     * @param entity 医生实体
     */
    @Transactional(rollbackFor = Exception.class)
    void insertDoctor(Doctor entity);

    /**
     * 通过uuid搜索医生id
     *
     * @param uuid uuid
     * @return 医生id
     */
    Integer searchIdByUuid(String uuid);
}




