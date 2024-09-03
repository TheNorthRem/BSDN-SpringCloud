package com.bupt.bnuser.service;

import cn.hutool.core.lang.Assert;
import com.bupt.bnuser.dao.po.BnUserPO;
import com.bupt.bnuser.dao.repository.UserRepository;
import com.bupt.bnuser.enums.UserResponseMessage;
import com.bupt.bnuser.enums.UserStatusEnum;
import com.bupt.bnuser.model.dto.LoginModelDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class BnUserService {

    @Autowired
    private UserRepository userRepository;
    public boolean login(LoginModelDTO loginModelDTO){
        BnUserPO userPO = userRepository.getByUsername(loginModelDTO.getUsername());
        Assert.notNull(userPO, UserResponseMessage.USER_NOT_EXIST);
        Assert.notEquals(userPO.getStatus(), UserStatusEnum.FROZEN.getCode(),"用户账号已冻结");

        // Todo : to be finished
        return true;
    }

}
