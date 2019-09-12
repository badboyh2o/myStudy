package com.hqxu.mode.BuilderMode;

public class GongyuBuilder implements HouseBuilder{

    House house = new House();
    
    
    @Override
    public void makeFloor() {
        house.setFloor("gongyu -> build floor");
    }

    @Override
    public void makeWall() {
        house.setWall("gongyu -> build wall");
    }

    @Override
    public void makeTop() {
        house.setHouseTop("gongyu -> build top");    
    }

    @Override
    public House getHouse() {
        return house;
    }

}
