package com.hqxu.mode.StrategyMode;

public class Main {

    public static void main(String[] args) {
        Context context = new Context(new MD5Stategy());
        context.encrypt(); // MD5
    }
}
