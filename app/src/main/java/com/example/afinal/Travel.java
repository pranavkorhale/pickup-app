package com.example.afinal;

import java.util.Date;

public class Travel {


    private String phone_no;
    private String location;
    private String destination;
    private String Vehicle_name;
    private String time;
    private String name;
    private String currentdate;

    private String mix;

    private Date created;
    private Date updated;
    private String objectId;

    public String getCurrentdate() {
        return currentdate;
    }

    public void setCurrentdate(String currentdate) {
        this.currentdate = currentdate;
    }

    public String getMix() {
        return mix;
    }

    //here we make table from this activity

    public void setMix(String mix) {
        this.mix = mix;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getVehicle_name() {
        return Vehicle_name;
    }

    public void setVehicle_name(String vehicle_name) {
        Vehicle_name = vehicle_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }
}