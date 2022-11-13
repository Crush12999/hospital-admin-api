package com.sryzzz.hospital.db.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sryzzz.hospital.db.entity.MisUser;

import java.util.ArrayList;
import java.util.Map;

/**
 * MisUserMapper
 *
 * @author sryzzz
 * @create 2022/11/13 14:03
 * @description MisUserMapper
 */
public interface MisUserMapper extends BaseMapper<MisUser> {

    /**
     * 通过userId获取用户权限列表
     *
     * @param userId 用户id
     * @return 用户权限列表
     */
    ArrayList<String> searchUserPermissions(int userId);

    /**
     * 登录
     *
     * @param param 登录参数
     * @return 用户id
     */
    Integer login(Map<String, Object> param);
}




