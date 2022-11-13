package com.sryzzz.hospital.config;

import cn.dev33.satoken.stp.StpInterface;
import com.sryzzz.hospital.db.mapper.MisUserMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * SaToken配置类
 *
 * @author sryzzz
 * @create 2022/11/13 14:03
 * @description SaToken配置类
 */
@Component
public class StpInterfaceImpl implements StpInterface {
    @Resource
    private MisUserMapper misUserMapper;

    /**
     * 返回一个用户所拥有的权限集合
     */
    @Override
    public List<String> getPermissionList(Object loginId, String loginKey) {
        int userId = Integer.parseInt(loginId.toString());
        return misUserMapper.searchUserPermissions(userId);
    }


    /**
     * 返回一个用户所拥有的角色标识集合
     */
    @Override
    public List<String> getRoleList(Object loginId, String loginKey) {
        return null;
    }

}