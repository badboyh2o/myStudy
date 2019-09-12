package com.hqxu.mode.StrategyMode;

public class Context {
    private Strategy stategy;

    public Context(Strategy stategy) {
        super();
        this.stategy = stategy;
    }
    
    public void encrypt() {
        this.stategy.encrypt();
    }

    
}
