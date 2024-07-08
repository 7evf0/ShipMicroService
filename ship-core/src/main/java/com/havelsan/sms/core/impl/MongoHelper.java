package com.havelsan.sms.core.impl;

import com.havelsan.sms.core.api.MongoHelperInterface;
import com.havelsan.sms.data.ShipDao;

import java.util.List;
import java.util.Map;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

@Component
public class MongoHelper implements MongoHelperInterface {

    private final MongoTemplate mongoTemplate;

    public MongoHelper(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public List<ShipDao> findShipList(Map<String, Object> filter){
        Query query = new Query();
        for(Map.Entry<String, Object> entry : filter.entrySet()) {
            query.addCriteria(Criteria.where(entry.getKey()).is(entry.getValue()));
        }
        return mongoTemplate.find(query, ShipDao.class);
    };

    @Override
    public List<ShipDao> findShipList(String key, Object value){
        Query query = new Query();
        query.addCriteria(Criteria.where(key).regex(".*" + value + ".*", "i"));
        return mongoTemplate.find(query, ShipDao.class);
    };

}
