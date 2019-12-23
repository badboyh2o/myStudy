package com.hqxu.mode.FactoryModePractice;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        
        double result = 0;
        Operation operation = null;
        
        System.out.println("the first num");
        Scanner scanner = new Scanner(System.in);
        Double num1 = Double.parseDouble(scanner.nextLine());
        
        
        System.out.println("the operation");
        String op = scanner.nextLine();
        
        System.out.println("the second num");
        Double num2 = Double.parseDouble(scanner.nextLine());
        
        // 获取 operation
        operation = OperationFactory.getOperation(op);
        operation.setNum1(num1);
        operation.setNum2(num2);
        result = operation.getResult();
        
        System.out.println("retult: " + result);
        
    }
    

    
}
