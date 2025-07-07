package com.example.emailservice.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {

    @Bean
    public NewTopic topic() {
        return TopicBuilder
                .name("emails")
                .build();
    }

//    @Bean
//    public RecordMessageConverter messageConverter() {
//        return new StringJsonMessageConverter();
//    }
}
