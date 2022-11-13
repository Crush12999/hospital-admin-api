package com.sryzzz.hospital.db.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sryzzz.hospital.db.entity.MisUser;

import java.util.ArrayList;

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
}




