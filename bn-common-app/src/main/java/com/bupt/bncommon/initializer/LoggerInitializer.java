package com.bupt.bncommon.initializer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Component
@Slf4j
public class LoggerInitializer implements ApplicationRunner {
    @Value("${spring.application.name}")
    private String appName;
    private String hostName = "null";
    private String ip = "null";
    public void reloadLog4j() {
        log.info("initializing");
        try {
            hostName =  InetAddress.getLocalHost().getHostName();
            ip = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            //doNothing
        }finally {
            System.setProperty("hostName", hostName);
            System.setProperty("ip",ip);
            System.setProperty("appName",appName);
        }
    }

    @Override
    public void run(ApplicationArguments args) {
        reloadLog4j();
    }

}
