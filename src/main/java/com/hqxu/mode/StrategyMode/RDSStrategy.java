package com.hqxu.mode.StrategyMode;

public class RDSStrategy implements Strategy{

    @Override
    public void encrypt() {
        System.out.println("RDS");
    }

}
