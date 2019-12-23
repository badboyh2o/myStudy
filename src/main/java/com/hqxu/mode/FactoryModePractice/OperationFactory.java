package com.hqxu.mode.FactoryModePractice;

public class OperationFactory {

    public static Operation getOperation(String op) {
        
        if("+".equals(op)) {
            return new AddOperation();
        }
        return null;
    }
    
    
}
