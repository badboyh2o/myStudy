package com.hqxu.json.fastjson.entity;

import java.util.Date;

public class Student {

    private String name;
    private Integer age;
    private Boolean isMarried;
    private Double money;
    private Float height;
    private Date birth;
    
    
    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + ", isMarried=" + isMarried + ", money=" + money + ", height="
                + height + ", birth=" + birth + "]";
    }
    public Date getBirth() {
        return birth;
    }
    public void setBirth(Date birth) {
        this.birth = birth;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public Boolean getIsMarried() {
        return isMarried;
    }
    public void setIsMarried(Boolean isMarried) {
        this.isMarried = isMarried;
    }
    public Double getMoney() {
        return money;
    }
    public void setMoney(Double money) {
        this.money = money;
    }
    public Float getHeight() {
        return height;
    }
    public void setHeight(Float height) {
        this.height = height;
    }
    
    
    
    
}
