package com.havelsan.sms.endpoint.api;

import com.havelsan.sms.data.ShipDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api.com.havelsan/sms/v1/ships")
public interface ShipControllerInterface {

    @PostMapping(path = "/")
    public ResponseEntity<ShipDto> send(@RequestBody ShipDto msg);

    @PutMapping(path = "/{id}")
    public ResponseEntity<ShipDto> update(@PathVariable String id, @RequestBody ShipDto msg);

    @GetMapping(path="/{id}")
    public ResponseEntity<ShipDto> getShipById(@PathVariable String id);

    @GetMapping(path="/")
    public ResponseEntity<List<ShipDto>> getAllShipsFiltered(@RequestParam Map<String,Object> req);

    @GetMapping(path="/name/{name}")
    public ResponseEntity<List<ShipDto>> searchShipsByName(@PathVariable String name);

    @GetMapping(path="/flag/{flag}")
    public ResponseEntity<List<ShipDto>> searchShipsByFlag(@PathVariable String flag);

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id);

}
