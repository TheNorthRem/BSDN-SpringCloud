package com.bupt.bnuser.dao.repository;

import cn.hutool.core.lang.Assert;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bupt.bncommon.enums.HttpEnums;
import com.bupt.bncommon.util.AssertUtils;
import com.bupt.bnuser.dao.mapper.BnUserMapper;
import com.bupt.bnuser.dao.po.BnUserPO;
import com.bupt.bnuser.enums.UserStatusEnum;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;

@Service
public class UserRepository extends ServiceImpl<BnUserMapper, BnUserPO> implements IService<BnUserPO> {
    public BnUserPO getByUsername(String username) {
        return lambdaQuery().eq(username != null, BnUserPO::getUsername, username).getEntity();
    }

    public BnUserPO registerUser(BnUserPO user) {
        Long count = lambdaQuery().eq(BnUserPO::getUsername, user.getUsername()).count();
        AssertUtils.isTrue(count == 0, "用户名已存在" , HttpEnums.BAD_REQUEST);
        user.setStatus(UserStatusEnum.NORMAL.getCode());
        user.setCreateTime(LocalDateTime.now());
        user.setUpdateTime(LocalDateTime.now());
        boolean save = save(user);
        AssertUtils.isTrue(save, "注册失败" , HttpEnums.INTERNAL_SERVER_ERROR);
        return user;
    }

}
