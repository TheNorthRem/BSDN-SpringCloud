package com.bupt.bnlogger.elasticsearch;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.convert.ElasticsearchCustomConversions;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;

/**
 * @Description: ES相关设置(时间和Long的转换)
 * @author: Jungle
 * @date: 2024年09月12日 22:32
 */

@Configuration
@EnableElasticsearchRepositories
public class ElasticsearchConfig {
    @Bean
    public ElasticsearchCustomConversions elasticsearchCustomConversions() {
        List<Converter<?, ?>> converters = new ArrayList<>();
        converters.add(new LongToTimestampConverter());
        converters.add(new TimestampToLongConverter());
        return new ElasticsearchCustomConversions(converters);
    }

    // Long -> Timestamp
    private static class LongToTimestampConverter implements Converter<Long, Timestamp> {
        @Override
        public Timestamp convert(@NonNull Long source) {
            return new Timestamp(source);
        }
    }

    // Timestamp -> Long
    private static class TimestampToLongConverter implements Converter<Timestamp, Long> {
        @Override
        public Long convert(@NonNull Timestamp source) {
            return source.getTime();
        }
    }
}
