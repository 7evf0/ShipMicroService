package com.havelsan.sms.core.api;

import com.havelsan.sms.data.ShipDao;
import com.havelsan.sms.data.ShipDto;

import java.util.List;

public interface ObjectConverterInterface {

    ShipDto shipDaoToShipDto(ShipDao shipDao);
    ShipDao shipDtoToShipDao(ShipDto shipDto);
    List<ShipDto> shipDaoToShipDto(List<ShipDao> shipDao);
}
