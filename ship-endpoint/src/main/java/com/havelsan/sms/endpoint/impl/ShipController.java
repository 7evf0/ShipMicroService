package com.havelsan.sms.endpoint.impl;

import com.havelsan.sms.core.impl.ObjectConverter;
import com.havelsan.sms.core.impl.ShipService;
import com.havelsan.sms.data.ShipDao;
import com.havelsan.sms.data.ShipDto;
import com.havelsan.sms.endpoint.api.ShipControllerInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api.com.havelsan/sms/v1/ships")
@ComponentScan(basePackages = {"com.havelsan.sms.core.*"})
public class ShipController implements ShipControllerInterface {

    private final ShipService service;
    private final ObjectConverter objectConverter;

    @Autowired
    public ShipController(ShipService service, ObjectConverter objectConverter) {
        this.service = service;
        this.objectConverter = objectConverter;
    }

    @PostMapping
    public ResponseEntity<ShipDto> send(@RequestBody ShipDto msg) {
        ShipDao shipDao = service.addShip(msg);
        ShipDto shipDto = objectConverter.shipDaoToShipDto(shipDao);
        return ResponseEntity.status(201).body(shipDto);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<ShipDto> update(@PathVariable("id") String id, @RequestBody ShipDto msg) {
        ShipDao shipDao = service.updateShip(id, msg);
        ShipDto shipDto = objectConverter.shipDaoToShipDto(shipDao);
        return ResponseEntity.status(200).body(shipDto);
    }

    @GetMapping(path="/")
    public ResponseEntity<List<ShipDto>> getAllShipsFiltered(@RequestParam Map<String,Object> req) {
            List<ShipDao> ships = service.getShipsFiltered(req);
            return ResponseEntity.ok(objectConverter.shipDaoToShipDto(ships));
    }

    @GetMapping(path="/{id}")
    public ResponseEntity<ShipDto> getShipById(@PathVariable String id) {
        ShipDao ship = service.getShipById(id);
        return ResponseEntity.ok(objectConverter.shipDaoToShipDto(ship));
    }

    @GetMapping(path="/name/{name}")
    public ResponseEntity<List<ShipDto>> searchShipsByName(@PathVariable String name) {
            List<ShipDao> ships = service.searchShipsByName(name);
            return ResponseEntity.ok(objectConverter.shipDaoToShipDto(ships));
    }

    @GetMapping(path="/flag/{flag}")
    public ResponseEntity<List<ShipDto>> searchShipsByFlag(@PathVariable String flag){
        List<ShipDao> ships = service.searchShipsByFlag(flag);
        return ResponseEntity.ok(objectConverter.shipDaoToShipDto(ships));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.deleteShip(id);
        return ResponseEntity.noContent().build();
    }
}
