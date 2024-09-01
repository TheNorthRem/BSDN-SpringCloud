package com.bupt.bnlogger.model.logger;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @Description: 日志消息内容
 */
@Data
public class KafkaLogBO {
    private Long timeWillis;

    private String thread;

    private String level;

    private String loggerName;

    private String message;

    private Boolean endOfBatch;

    private String loggerFocn;

    private Long threadId;

    private Integer threadPriority;

    private Timestamp timestamp;

    private String appName;

    private String ip;

    private String hostName;
}
