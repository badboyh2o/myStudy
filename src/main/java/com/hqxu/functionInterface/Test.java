package com.hqxu.functionInterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Test {

    public static void main(String[] args) {
        
        //集合的遍历
        List<String> list = Arrays.asList("1","2");
        list.forEach(s -> {
            s = s + "a";
            System.out.println(s);
        });
        
        
        //lambda
        t1 t = () -> {};
        System.out.println(t.getClass().getInterfaces()[0]);
        
        
        //Function
        Test test = new Test();
        System.out.println(test.count(2, a -> a*5));
        System.out.println(test.count1(2, 3, (a,b) -> a+b));
        
        System.out.println(test.count2(1, a -> a*2, a -> a+2));
        
    }
    
    
    private Integer count(Integer a, Function<Integer,Integer> function)
    {
        return function.apply(a);
    }

    private Integer count1(Integer a, Integer b, BiFunction<Integer,Integer,Integer> Bifunction)
    {
        return Bifunction.apply(a,b);
    }
    
    private Integer count2(Integer a, Function<Integer,Integer> function, Function<Integer,Integer> before)
    {
        return function.compose(before).apply(a);
    }
}


@FunctionalInterface
interface t1
{
    public void a();
}