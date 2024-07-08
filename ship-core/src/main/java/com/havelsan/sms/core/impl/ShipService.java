package com.havelsan.sms.core.impl;

import com.havelsan.sms.core.api.ShipServiceInterface;
import com.havelsan.sms.core.config.exception.ClassNotExistsException;
import com.havelsan.sms.data.Constants;
import com.havelsan.sms.data.ShipDao;
import com.havelsan.sms.data.ShipDto;
import com.havelsan.sms.repository.ShipRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ShipService implements ShipServiceInterface {

    private final ShipRepository shipRepository;
    private final MongoHelper mongoHelper;
    private final KafkaHelper kafkaHelper;
    private final ObjectConverter objectConverter;

    public ShipService(MongoHelper mongoHelper, KafkaHelper kafkaHelper, ShipRepository shipRepository, ObjectConverter objectConverter) {
        this.mongoHelper = mongoHelper;
        this.kafkaHelper = kafkaHelper;
        this.shipRepository = shipRepository;
        this.objectConverter = objectConverter;
    }

    @Override
    public List<ShipDao> getAllShips() {
        return shipRepository.findAll();
    }

    @Override
    public ShipDao getShipById(String id) {
        if (shipRepository.findById(id).isPresent()) {
            return shipRepository.findById(id).get();
        } else {
            throw new ClassNotExistsException("Cannot fetch the ship with id: " + id);
        }
    }

    @Override
    public List<ShipDao> getShipsFiltered(Map<String, Object> req) {
        return mongoHelper.findShipList(req);
    }

    @Override
    public List<ShipDao> searchShipsByName(String text) {
        return mongoHelper.findShipList("name", text);
    }

    @Override
    public List<ShipDao> searchShipsByFlag(String flag) {
        return mongoHelper.findShipList("flag", flag);
    }

    @Override
    public ShipDao addShip(ShipDto shipDto) {
        ShipDao shipDao = objectConverter.shipDtoToShipDao(shipDto);
        ShipDao resultShip = shipRepository.save(shipDao);
        kafkaHelper.sendMessage(Constants.TOPIC_SHIP_ADD, resultShip.getId(), resultShip);
        return resultShip;
    }

    @Override
    public ShipDao updateShip(String id, ShipDto shipDto) {
        Optional<ShipDao> optionalShip = shipRepository.findById(id);
        ShipDao shipDao = objectConverter.shipDtoToShipDao(shipDto);
        if (optionalShip.isPresent()) {
            shipDao.setId(id);
            shipRepository.save(shipDao);
            kafkaHelper.sendMessage(Constants.TOPIC_SHIP_UPDATE, id, shipDao);
        } else {
            System.out.println("Cannot find the ship with id: " + id);
            throw new ClassNotExistsException("Cannot find the ship with id: " + id + ". Cannot update the ship.");
        }
        return shipDao;
    }

    @Override
    public void deleteShip(String id) {
        if (shipRepository.findById(id).isEmpty()) {
            throw new ClassNotExistsException("Cannot find the ship with id: " + id + ". Cannot delete ship.");
        }
        ShipDao oldShipDao = getShipById(id);
        shipRepository.deleteById(id);
        kafkaHelper.sendMessage(Constants.TOPIC_SHIP_DELETE, id, oldShipDao);
    }
}
