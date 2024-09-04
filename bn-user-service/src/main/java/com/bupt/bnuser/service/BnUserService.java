package com.bupt.bnuser.service;

import cn.hutool.core.lang.Assert;
import com.bupt.bnuser.dao.po.BnUserPO;
import com.bupt.bnuser.dao.repository.UserRepository;
import com.bupt.bnuser.enums.UserResponseMessage;
import com.bupt.bnuser.enums.UserStatusEnum;
import com.bupt.bnuser.model.dto.LoginModelDTO;
import com.bupt.bnuser.model.dto.LoginResultDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class BnUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public LoginResultDTO login(LoginModelDTO loginModelDTO){
        BnUserPO userPO = userRepository.getByUsername(loginModelDTO.getUsername());
        Assert.notNull(userPO, UserResponseMessage.USER_NOT_EXIST);
        Assert.notEquals(userPO.getStatus(), UserStatusEnum.FROZEN.getCode(),UserResponseMessage.USER_FROZEN);
        Assert.isTrue(passwordEncoder.matches(loginModelDTO.getPassword(),userPO.getPassword()),UserResponseMessage.USERNAME_OR_PASSWORD_ERROR);
        // Todo : to be finished
        String token = "";

        return LoginResultDTO.builder()
                .userId(userPO.getBnUserId())
                .nickName(userPO.getNickName())
                .username(userPO.getUsername())
                .token(token)
                .build();
    }

}
