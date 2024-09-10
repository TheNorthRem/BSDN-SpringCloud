package com.bupt.bnuser.controller;

import com.bupt.bncommon.enums.HttpEnums;
import com.bupt.bncommon.response.ApiResult;
import com.bupt.bncommon.util.AssertUtils;
import com.bupt.bnuser.facade.BnUserFacade;
import com.bupt.bnuser.model.bo.RegisterModelBO;
import com.bupt.bnuser.model.bo.RegisterResultBO;
import com.bupt.bnuser.model.vo.BnUserVO;
import com.bupt.bnuser.service.BnUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 1.0
 * @Author liyehui02
 * @Date 2024/9/10 上午11:19
 */
@RestController
@Slf4j
public class UserController {

    @Autowired
    private BnUserFacade bnUserFacade;

    public ApiResult<BnUserVO> register(RegisterModelBO registerModelDTO) {
        return new ApiResult<>(bnUserFacade.register(registerModelDTO));
    }
}
