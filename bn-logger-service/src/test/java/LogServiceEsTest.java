import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.io.resource.ClassPathResource;
import com.bupt.bnlogger.BnLoggerAppApplication;
import com.bupt.bnlogger.elasticsearch.KafkaLogRepository;
import com.bupt.bnlogger.model.logger.KafkaLogBO;
import com.bupt.bnlogger.model.logger.KafkaLogPO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Description: ES存储Kafka消息测试
 * @author: scott
 * @date: 2024年09月12日 18:05
 */

@SpringBootTest(classes = BnLoggerAppApplication.class)
@Slf4j
public class LogServiceEsTest {
    private final KafkaLogRepository kafkaLogRepository;

    private static final ClassPathResource KafkaLogDataFile = new ClassPathResource("KafkaLogData.json");

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    public LogServiceEsTest(KafkaLogRepository kafkaLogRepository) {
        this.kafkaLogRepository = kafkaLogRepository;
    }

    @BeforeEach
    public void cleanStore() {
        kafkaLogRepository.deleteAll();
        log.info("clear ES up");
    }

    /**
     * @Description: 测试ES的基本读写能力
     */
    @Test
    public void testKafkaLogToES() throws IOException {
        try (InputStream inputStream = KafkaLogDataFile.getStream()) {
            List<KafkaLogBO> boLogs = objectMapper.readValue(inputStream, new TypeReference<List<KafkaLogBO>>() {
            });
            System.out.println(boLogs);
            List<KafkaLogPO> poLogs = boLogs.stream()
                    .map(kafkaLogBO -> BeanUtil.copyProperties(kafkaLogBO, KafkaLogPO.class))
                    .collect(Collectors.toList());
            System.out.println(poLogs);
            kafkaLogRepository.saveAll(poLogs);
            Set<KafkaLogPO> readSet = new HashSet<>();
            kafkaLogRepository.findAll().forEach(readSet::add);
            Set<KafkaLogPO> writeSet = new HashSet<>(poLogs);
            Assertions.assertEquals(readSet, writeSet);
        }
    }
}
