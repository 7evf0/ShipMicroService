package com.havelsan.sms.core.impl;

import com.havelsan.sms.core.api.KafkaHelperInterface;
import com.havelsan.sms.data.ShipDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaHelper implements KafkaHelperInterface {

    private final KafkaTemplate<String, ShipDao> kafkaTemplate;

    @Autowired
    public KafkaHelper(KafkaTemplate<String, ShipDao> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String topic, String key, ShipDao shipDao) {
        kafkaTemplate.send(topic, key, shipDao);
    }

}
