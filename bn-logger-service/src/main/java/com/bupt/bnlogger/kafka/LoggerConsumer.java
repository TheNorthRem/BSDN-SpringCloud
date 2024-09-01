package com.bupt.bnlogger.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

/**
 * @Description: 日志收集服务
 * @author: Jungle
 * @date: 2024年08月31日 21:18
 */

@Service
@Slf4j
public class LoggerConsumer {
    @KafkaListener(topics = "bn-topic-user", groupId = "consumer")
    public void logListen(@NonNull ConsumerRecord<String, String> record) {
        log.info("has received:{}", record.value());
    }
}
