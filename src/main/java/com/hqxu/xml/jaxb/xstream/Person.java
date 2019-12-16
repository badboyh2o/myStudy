package com.hqxu.xml.jaxb.xstream;

import java.util.List;
import java.util.Map;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import com.thoughtworks.xstream.converters.basic.BooleanConverter;

@XStreamAlias("person")
public class Person {
    @XStreamConverter(value=BooleanConverter.class, booleans={false}, strings={"yes", "no"})
    private boolean married;
    private double salary;
    private int age;
    private String name;
    private String firstname;
    
    @XStreamImplicit(itemFieldName="hobby")
    private List<String> hobbies;
    
    //@XStreamImplicit(keyFieldName="myentry")
    private Map<String, String> fruits;
    
    //@XStreamImplicit(itemFieldName="addresses")
    @XStreamAlias("addresses")
    private List<Address> addresses;
    
    public Person(boolean married, double salary, int age, String name, List<String> hobbies, List<Address> addresses) {
        super();
        this.married = married;
        this.salary = salary;
        this.age = age;
        this.name = name;
        this.hobbies = hobbies;
        this.addresses = addresses;
    }

    public Person(String name, List<String> hobbies, List<Address> addresses) {
        super();
        this.name = name;
        this.hobbies = hobbies;
        this.addresses = addresses;
    }

    @Override
    public String toString() {
        return "Person [married=" + married + ", salary=" + salary + ", age=" + age + ", name=" + name + ", hobbies="
                + hobbies + ", addresses=" + addresses + "]";
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public Map<String, String> getFruits() {
        return fruits;
    }

    public void setFruits(Map<String, String> fruits) {
        this.fruits = fruits;
    }
    
}
