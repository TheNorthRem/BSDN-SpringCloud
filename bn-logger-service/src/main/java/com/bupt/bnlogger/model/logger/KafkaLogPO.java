package com.bupt.bnlogger.model.logger;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.sql.Timestamp;

/**
 * @Description: Kafka消息持久化
 * @author: Jungle
 * @date: 2024年09月01日 21:02
 */

@Data
@Document(indexName = "kafka_logs")
public class KafkaLogPO {
    @Id
    private String uniqueId;

    private Long timeMillis;

    private String level;

    private String message;

    private Timestamp time;

    private String appName;

    private String ip;

    private String hostName;

    public void makeUniqueId() {
        uniqueId = String.format("%s %s %s", appName, ip, hostName);
    }
}
