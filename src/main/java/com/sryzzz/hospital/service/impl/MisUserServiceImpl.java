package com.sryzzz.hospital.service.impl;

import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.digest.MD5;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sryzzz.hospital.db.entity.MisUser;
import com.sryzzz.hospital.db.mapper.MisUserMapper;
import com.sryzzz.hospital.service.MisUserService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * MIS系统用户Service层实现
 *
 * @author sryzzz
 * @create 2022/11/13 17:58
 * @description MIS系统用户Service层实现
 */
@Service
public class MisUserServiceImpl extends ServiceImpl<MisUserMapper, MisUser>
        implements MisUserService {

    /**
     * 登录
     */
    @Override
    public Integer login(Map<String, Object> param) {
        String username = MapUtil.getStr(param, "username");
        String password = MapUtil.getStr(param, "password");
        MD5 md5 = MD5.create();
        String temp = md5.digestHex(username);
        // 前六位字符
        String tempStart = StrUtil.subWithLength(temp, 0, 6);
        // 后三位字符
        String tempEnd = StrUtil.subSuf(temp, temp.length() - 3);
        // 混淆原始密码并哈希加密
        password = md5.digestHex(tempStart + password + tempEnd);
        param.replace("password", password);
        return baseMapper.login(param);
    }
}
