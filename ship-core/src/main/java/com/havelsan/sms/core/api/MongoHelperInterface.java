package com.havelsan.sms.core.api;

import com.havelsan.sms.data.ShipDao;

import java.util.List;
import java.util.Map;

public interface MongoHelperInterface {

    List<ShipDao> findShipList(Map<String, Object> filter);
    List<ShipDao> findShipList(String key, Object value);

}
