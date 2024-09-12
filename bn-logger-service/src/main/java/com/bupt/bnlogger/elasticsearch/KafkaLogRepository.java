package com.bupt.bnlogger.elasticsearch;

import com.bupt.bnlogger.model.logger.KafkaLogPO;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * @Description: ES对Kafka消息的配置
 * @author: Jungle
 * @date: 2024年09月12日 17:42
 */
public interface KafkaLogRepository extends ElasticsearchRepository<KafkaLogPO, String> {

    List<KafkaLogPO> findByUniqueId(String uniqueId);
}
