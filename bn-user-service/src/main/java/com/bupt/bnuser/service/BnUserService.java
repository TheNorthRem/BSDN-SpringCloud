package com.bupt.bnuser.service;

import cn.hutool.core.bean.BeanUtil;
import com.bupt.bncommon.enums.HttpEnums;
import com.bupt.bncommon.util.AssertUtils;
import com.bupt.bnuser.dao.po.BnUserPO;
import com.bupt.bnuser.dao.repository.UserRepository;
import com.bupt.bnuser.enums.UserResponseMessage;
import com.bupt.bnuser.enums.UserStatusEnum;
import com.bupt.bnuser.model.dto.LoginModelDTO;
import com.bupt.bnuser.model.bo.LoginResultBO;
import com.bupt.bnuser.model.bo.RegisterModelBO;
import com.bupt.bnuser.model.bo.RegisterResultBO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class BnUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public LoginResultBO login(LoginModelDTO loginModelDTO) {
        BnUserPO userPO = userRepository.getByUsername(loginModelDTO.getUsername());
        AssertUtils.notNull(userPO,UserResponseMessage.USER_NOT_EXIST, HttpEnums.BAD_REQUEST);
        AssertUtils.notEquals(userPO.getStatus(), UserStatusEnum.FROZEN.getCode(),UserResponseMessage.USER_FROZEN,HttpEnums.FORBIDDEN);
        AssertUtils.isTrue(passwordEncoder.matches(loginModelDTO.getPassword(), userPO.getPassword()), UserResponseMessage.USERNAME_OR_PASSWORD_ERROR,HttpEnums.BAD_REQUEST);

        return LoginResultBO.builder()
                .userId(userPO.getBnUserId())
                .nickName(userPO.getNickName())
                .username(userPO.getUsername())
                .build();
    }

    public RegisterResultBO register(RegisterModelBO registerModelDTO) {

        BnUserPO userPO = new BnUserPO();
        userPO.setUsername(registerModelDTO.getUsername());
        userPO.setPassword(passwordEncoder.encode(registerModelDTO.getPassword()));
        userPO.setNickName(registerModelDTO.getNickName());

        BnUserPO bnUserPO = userRepository.registerUser(userPO);

        AssertUtils.notNull(bnUserPO,"注册失败",HttpEnums.BAD_REQUEST);

        RegisterResultBO registerResultBO = new RegisterResultBO();

        BeanUtils.copyProperties(bnUserPO,registerResultBO);

        return registerResultBO;
    }


}
