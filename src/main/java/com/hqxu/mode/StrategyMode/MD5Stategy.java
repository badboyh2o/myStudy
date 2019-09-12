package com.hqxu.mode.StrategyMode;

public class MD5Stategy implements Strategy{

    @Override
    public void encrypt() {
        System.out.println("MD5");
    }

}
