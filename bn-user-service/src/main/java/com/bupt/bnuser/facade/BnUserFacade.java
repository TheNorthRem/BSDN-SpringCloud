package com.bupt.bnuser.facade;

import com.bupt.bncommon.enums.HttpEnums;
import com.bupt.bncommon.response.ApiResult;
import com.bupt.bncommon.util.AssertUtils;
import com.bupt.bnuser.model.bo.LoginResultBO;
import com.bupt.bnuser.model.bo.RegisterModelBO;
import com.bupt.bnuser.model.bo.RegisterResultBO;
import com.bupt.bnuser.model.dto.LoginModelDTO;
import com.bupt.bnuser.model.vo.BnUserVO;
import com.bupt.bnuser.service.BnUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @version 1.0
 * @Author liyehui02
 * @Date 2024/9/10 上午11:38
 */
@Service
@Slf4j
public class BnUserFacade {
    @Autowired
    private BnUserService bnUserService;

    public BnUserVO register(RegisterModelBO registerModelDTO) {

        log.info("UserController register registerModelDTO:{}", registerModelDTO.getUsername());

        RegisterResultBO register = null;
        try {
            register = bnUserService.register(registerModelDTO);
        } catch (Exception e) {
            log.error("UserController register error registerModelDTO:{}", registerModelDTO.getUsername(), e);
            throw e;
        }

        AssertUtils.notNull(register, "注册失败", HttpEnums.INTERNAL_SERVER_ERROR);
        BnUserVO bnUserVO = new BnUserVO();

        BeanUtils.copyProperties(register, bnUserVO);

        return bnUserVO;
    }

    public BnUserVO login(LoginModelDTO loginModelDTO) {
        LoginResultBO login = bnUserService.login(loginModelDTO);
        AssertUtils.notNull(login, "登录失败", HttpEnums.INTERNAL_SERVER_ERROR);
        BnUserVO bnUserVO = new BnUserVO();
        BeanUtils.copyProperties(login, bnUserVO);
        return bnUserVO;
    }
}
