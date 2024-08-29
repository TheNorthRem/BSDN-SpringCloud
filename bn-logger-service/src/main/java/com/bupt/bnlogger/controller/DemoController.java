package com.bupt.bnlogger.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @version 1.0
 * @Author liyehui02
 * @Date 2024/8/29 下午5:30
 */
@Controller
@Slf4j
public class DemoController {
    @GetMapping("/demo")
    public String demo() {
        log.info("test");
        return "12";
    }
}
