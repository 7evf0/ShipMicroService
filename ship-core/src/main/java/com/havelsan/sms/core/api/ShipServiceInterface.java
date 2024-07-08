package com.havelsan.sms.core.api;

import com.havelsan.sms.data.ShipDao;
import com.havelsan.sms.data.ShipDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface ShipServiceInterface {
    
    List<ShipDao> getAllShips();
    ShipDao getShipById(String id);
    List<ShipDao> getShipsFiltered(Map<String, Object> req);
    List<ShipDao> searchShipsByName(String text);
    List<ShipDao> searchShipsByFlag(String flag);

    ShipDao addShip(ShipDto shipDto);
    ShipDao updateShip(String id, ShipDto shipDto);
    void deleteShip(String id);

}