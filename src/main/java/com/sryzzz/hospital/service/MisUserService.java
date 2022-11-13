package com.sryzzz.hospital.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sryzzz.hospital.db.entity.MisUser;

import java.util.Map;

/**
 * MIS系统用户Service层
 *
 * @author sryzzz
 * @create 2022/11/13 17:57
 * @description MIS系统用户Service层
 */
public interface MisUserService extends IService<MisUser> {

    /**
     * 登录
     *
     * @param param 登录参数
     * @return 用户id
     */
    Integer login(Map<String, Object> param);
}
