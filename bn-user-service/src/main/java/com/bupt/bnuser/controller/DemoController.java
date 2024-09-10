package com.bupt.bnuser.controller;

import com.bupt.bncommon.response.ApiResult;
import com.bupt.bncommon.util.AssertUtils;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 1.0
 * @Author liyehui02
 * @Date 2024/8/29 下午5:30
 */
@RestController
@Slf4j
public class DemoController {
//    private static final Logger LOGGER = LoggerFactory.getLogger("test_logger");

    @GetMapping("/demo")
    public ApiResult demo(Integer code) {
        log.info("test");
        System.out.println("!23");
        return new ApiResult(200,"success");
    }

}
