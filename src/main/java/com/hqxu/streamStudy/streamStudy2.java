package com.hqxu.streamStudy;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class streamStudy2 {

    
    public static void main(String[] args) {
        
        Person person1 = new Person("lili",18);
        Person person2 = new Person("lisi",20);
        Person person3 = new Person("laowang",20);
        Person person4 = new Person("lili",25);
        
        List<Person> persons = Arrays.asList(person1,person2,person3,person4);
        
        //测试分组 groupingby
        Map<String, List<Person>> map = persons.stream().collect(Collectors.groupingBy(Person::getName,Collectors.toList()));
        System.out.println(map);
        
        System.out.println("============================");
        //测试分区 partitioningBy
        Map<Boolean, List<Person>> map1 = persons.stream().collect(Collectors.partitioningBy(person -> person.getAge() >= 20));
        System.out.println(map1);
        
    }
    
    
}
