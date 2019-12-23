package com.hqxu.optionalTest;

import java.util.Optional;

public class OptionalTest {

    
    public static void main(String[] args) {
       Optional<String> optional = Optional.of("String"); 
       
       
       
/*       if(optional.isPresent())
       {
           System.out.println(optional.get());
       }*/
       
       // 如果 optional 的值不为空, 则执行consumer
       optional.ifPresent(item -> System.out.println(item));
       
    }
   
    
    
    
}
