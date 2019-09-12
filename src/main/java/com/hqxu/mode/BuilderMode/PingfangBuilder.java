package com.hqxu.mode.BuilderMode;

public class PingfangBuilder implements HouseBuilder {

    House house = new House();
    
    
    @Override
    public void makeFloor() {
        house.setFloor("house -> build floor");
    }

    @Override
    public void makeWall() {
        house.setWall("house _> build wall");
        
    }

    @Override
    public void makeTop() {
        house.setHouseTop("house _> build top");
    }

    @Override
    public House getHouse() {
        
        return house;
    }
    
}
