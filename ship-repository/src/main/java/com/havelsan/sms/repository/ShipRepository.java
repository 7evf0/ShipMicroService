package com.havelsan.sms.repository;

import com.havelsan.sms.data.ShipDao;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipRepository extends MongoRepository<ShipDao, String> {
}
