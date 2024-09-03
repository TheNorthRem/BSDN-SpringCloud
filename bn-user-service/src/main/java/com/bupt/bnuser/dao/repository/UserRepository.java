package com.bupt.bnuser.dao.repository;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bupt.bnuser.dao.mapper.BnUserMapper;
import com.bupt.bnuser.dao.po.BnUserPO;
import org.springframework.stereotype.Service;

@Service
public class UserRepository extends ServiceImpl<BnUserMapper, BnUserPO> implements IService<BnUserPO> {
    public BnUserPO getByUsername(String username){
        return lambdaQuery().eq(username != null, BnUserPO::getUsername, username).getEntity();
    }
}
