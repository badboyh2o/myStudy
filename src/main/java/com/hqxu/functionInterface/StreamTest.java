package com.hqxu.functionInterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class StreamTest {

    
    public static void main(String[] args) {
        
        Person person1 = new Person("zhangsan",18);
        Person person2 = new Person("lisi", 28);
        Person person3 = new Person("wagnwu", 35);
        
        List<Person> perosns = Arrays.asList(person1,person2,person3);
        
        
        // 过滤集合
        List<Person> getPerosnsByname = getPersonByName("lisi",perosns);
        List<Person> getPerosnsByage = getPerosnByAge(20,perosns);
        
        // 遍历集合
        getPerosnsByname.forEach(perosn -> System.out.println(perosn));
        System.out.println("==========================================");
        getPerosnsByage.forEach(perosn -> System.out.println(perosn));
        
    }
    
    /**
     * 根据名字查找人
     * @param name
     * @param persons
     * @return
     */
    public static List<Person> getPersonByName(String name, List<Person> persons)
    {
        return persons.stream().filter(person -> person.getName().equals(name)).collect(Collectors.toList());
    }
    
    
    /**
     * 根据年龄查找人
     * @param age
     * @param persons
     * @return
     */
    public static List<Person> getPerosnByAge(Integer age, List<Person> persons)
    {
        BiFunction<Integer,List<Person>, List<Person>> biFunction = (ageofPerosn, personList) ->personList.stream().filter(person -> person.getAge()>ageofPerosn).collect(Collectors.toList());
        return biFunction.apply(age, persons);
    }
    
}
