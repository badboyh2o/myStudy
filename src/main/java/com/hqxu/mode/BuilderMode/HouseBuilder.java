package com.hqxu.mode.BuilderMode;

public interface HouseBuilder {

    // 建地板
    public void makeFloor();
    
    // 建墙壁
    public void makeWall();
    
    // 建屋顶
    public void makeTop();
    
    // 返回建好的房子
    public House getHouse();
    
    
}
