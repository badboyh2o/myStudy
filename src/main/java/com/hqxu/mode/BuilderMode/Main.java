package com.hqxu.mode.BuilderMode;

public class Main {

    public static void main(String[] args) {
        buildPingfang();
        buildGongyu();

    }
    
    public static void buildPingfang() {
        // 1.创建一个平房工程队
        HouseBuilder builder = new PingfangBuilder();

        // 1.设计者选择工程队建造
        HouseDirector director = new HouseDirector(builder);
        director.makeHouse();
        
        // 1.建造者建好了房子
        House house = builder.getHouse();
        System.out.println(house.toString());
    }
    
    public static void buildGongyu() {
        // 1.创建一个平房工程队
        HouseBuilder builder = new GongyuBuilder();

        // 1.设计者选择工程队建造
        HouseDirector director = new HouseDirector(builder);
        director.makeHouse();
        
        // 1.建造者建好了房子
        House house = builder.getHouse();
        System.out.println(house.toString());
    }
    
}
