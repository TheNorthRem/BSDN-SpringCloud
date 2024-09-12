package com.bupt.bnlogger.kafka;

import com.bupt.bnlogger.elasticsearch.KafkaLogRepository;
import com.bupt.bnlogger.model.logger.KafkaLogBO;
import com.bupt.bnlogger.model.logger.KafkaLogPO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import cn.hutool.core.bean.BeanUtil;

/**
 * @Description: 日志收集服务
 * @author: Jungle
 * @date: 2024年08月31日 21:18
 */

@Service
@Slf4j
public class LoggerConsumer {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    private final KafkaLogRepository kafkaLogRepository;

    @Autowired
    public LoggerConsumer(KafkaLogRepository kafkaLogRepository) {
        this.kafkaLogRepository = kafkaLogRepository;
    }

    @KafkaListener(topics = "bn-topic-user", groupId = "consumer")
    public void logListen(@NonNull ConsumerRecord<String, String> record) {
        try {
            // JSON转换后脱敏
            KafkaLogBO kafkaLogBO = objectMapper.readValue(record.value(), KafkaLogBO.class);
            KafkaLogPO kafkaLogPO = BeanUtil.copyProperties(kafkaLogBO, KafkaLogPO.class);
            log.info("Key:{}", record.key());
            log.info("has received:{}", kafkaLogBO);
            log.info("after filter: {}", kafkaLogPO);
            kafkaLogRepository.save(kafkaLogPO);
        } catch (JsonProcessingException e) {
            log.error("{}", e.getMessage());
        }
    }

    /**
     * @Description: 将Kafka消息存储到ES中
     * @author: Jungle
     * @param kafkaLogPO 需要存储的kafka消息
     */
    private void storeKafKaLogToEs(@NonNull KafkaLogPO kafkaLogPO) {
        kafkaLogPO.makeUniqueId();
        kafkaLogRepository.save(kafkaLogPO);
    }

    /**
     * @Description: 将Kafka消息存储到ES中
     * @author: Jungle
     * @param kafkaLogPOs 需要存储的kafka消息
     */
    private void storeKafkaLogsToEs(@NonNull Iterable<KafkaLogPO> kafkaLogPOs) {
        kafkaLogPOs.forEach(KafkaLogPO::makeUniqueId);
        kafkaLogRepository.saveAll(kafkaLogPOs);
    }
}
