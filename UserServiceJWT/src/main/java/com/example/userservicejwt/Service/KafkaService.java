package com.example.userservicejwt.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaService {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendEmail(String msg) {
    try {
        kafkaTemplate.send("emails", msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
