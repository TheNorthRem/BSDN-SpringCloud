package com.bupt.bnlogger.model.logger;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @Description: Kafka消息持久化
 * @author: Jungle
 * @date: 2024年09月01日 21:02
 */

@Data
public class KafkaLogPO {
    private Long timeMillis;

    private String level;

    private String message;

    private Timestamp time;

    private String appName;

    private String ip;

    private String hostName;
}
