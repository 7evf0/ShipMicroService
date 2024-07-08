package com.havelsan.sms.data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Ship")
public class ShipDao {

    @Id
    private String id;

    private String imoNo;
    private String mmsi;
    private String name;
    private String type;
    private Short constructionYear;
    private Float breadth;
    private Float deadWeightTonnage;
    private Float draught;
    private Float length;
    private Float grossTonnage;
    private Float netTonnage;
    private String callSign;
    private String flag;
    private Float maxSpeed;

    public void setImo_no(String imoNo) {
        this.imoNo = imoNo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMmsi(String mmsi) {
        this.mmsi = mmsi;
    }

    public String getName() {
        return name;
    }

    public String getMmsi() {
        return mmsi;
    }

    public String getType() {
        return type;
    }

    public Float getBreadth() {
        return breadth;
    }

    public Float getDeadWeightTonnage() {
        return deadWeightTonnage;
    }

    public Float getDraught() {
        return draught;
    }

    public Float getLength() {
        return length;
    }

    public Float getGrossTonnage() {
        return grossTonnage;
    }

    public Float getNetTonnage() {
        return netTonnage;
    }

    public String getCallSign() {
        return callSign;
    }

    public String getFlag() {
        return flag;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setBreadth(Float breadth) {
        this.breadth = breadth;
    }

    public void setDeadWeightTonnage(Float deadWeightTonnage) {
        this.deadWeightTonnage = deadWeightTonnage;
    }

    public void setDraught(Float draught) {
        this.draught = draught;
    }

    public void setLength(Float length) {
        this.length = length;
    }

    public void setGrossTonnage(Float grossTonnage) {
        this.grossTonnage = grossTonnage;
    }

    public void setNetTonnage(Float netTonnage) {
        this.netTonnage = netTonnage;
    }

    public void setCallSign(String callSign) {
        this.callSign = callSign;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getImoNo() {
        return imoNo;
    }

    public void setImoNo(String imoNo) {
        this.imoNo = imoNo;
    }

    public Float getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(Float maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public Short getConstructionYear() {
        return constructionYear;
    }

    public void setConstructionYear(Short constructionYear) {
        this.constructionYear = constructionYear;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
