package com.havelsan.sms.core.impl;

import com.havelsan.sms.core.api.ObjectConverterInterface;
import com.havelsan.sms.data.ShipDao;
import com.havelsan.sms.data.ShipDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ObjectConverter implements ObjectConverterInterface {

    public ShipDto shipDaoToShipDto(ShipDao shipDao){
        ShipDto shipDto = new ShipDto();

        shipDto.setId(shipDao.getId());
        shipDto.setBreadth(shipDao.getBreadth());
        shipDto.setCallSign(shipDao.getCallSign());
        shipDto.setFlag(shipDao.getFlag());
        shipDto.setDraught(shipDao.getDraught());
        shipDto.setMmsi(shipDao.getMmsi());
        shipDto.setLength(shipDao.getLength());
        shipDto.setConstructionYear(shipDao.getConstructionYear());
        shipDto.setDeadWeightTonnage(shipDao.getDeadWeightTonnage());
        shipDto.setGrossTonnage(shipDao.getGrossTonnage());
        shipDto.setImoNo(shipDao.getImoNo());
        shipDto.setNetTonnage(shipDao.getNetTonnage());
        shipDto.setMaxSpeed(shipDao.getMaxSpeed());
        shipDto.setName(shipDao.getName());
        shipDto.setType(shipDao.getType());

        return shipDto;
    }

    public ShipDao shipDtoToShipDao(ShipDto shipDto){
        ShipDao shipDao = new ShipDao();

        shipDao.setId(shipDto.getId());
        shipDao.setBreadth(shipDto.getBreadth());
        shipDao.setCallSign(shipDto.getCallSign());
        shipDao.setFlag(shipDto.getFlag());
        shipDao.setDraught(shipDto.getDraught());
        shipDao.setMmsi(shipDto.getMmsi());
        shipDao.setLength(shipDto.getLength());
        shipDao.setConstructionYear(shipDto.getConstructionYear());
        shipDao.setDeadWeightTonnage(shipDto.getDeadWeightTonnage());
        shipDao.setGrossTonnage(shipDto.getGrossTonnage());
        shipDao.setImoNo(shipDto.getImoNo());
        shipDao.setNetTonnage(shipDto.getNetTonnage());
        shipDao.setMaxSpeed(shipDto.getMaxSpeed());
        shipDao.setName(shipDto.getName());
        shipDao.setType(shipDto.getType());

        return shipDao;
    }

    @Override
    public List<ShipDto> shipDaoToShipDto(List<ShipDao> shipDao){
        List<ShipDto> shipDtoList = new ArrayList<>();
        for(ShipDao shipDaoDto : shipDao){
            ShipDto shipDto = shipDaoToShipDto(shipDaoDto);
            shipDtoList.add(shipDto);
        }
        return shipDtoList;
    }

}
