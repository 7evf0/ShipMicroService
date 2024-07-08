package com.havelsan.sms.core.api;

import com.havelsan.sms.data.ShipDao;

public interface KafkaHelperInterface {

    void sendMessage(String topic, String key, ShipDao message);

}
