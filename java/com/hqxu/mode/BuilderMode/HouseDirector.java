package com.hqxu.mode.BuilderMode;

public class HouseDirector {
    
    private HouseBuilder builder;


    public HouseDirector(HouseBuilder builder) {
        super();
        this.builder = builder;
    }
    

    //使用 工程建造
    public void makeHouse() {
        this.builder.makeFloor();
        this.builder.makeTop();
        this.builder.makeWall();
        
    }
    
}
