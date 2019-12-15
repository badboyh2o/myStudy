package com.hqxu.xml.jaxb.xstream;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("addr")
public class Address {
    @XStreamAlias("cityNo")
    private String id;
    @XStreamAlias("cityName")
    private String city;
    
    public Address(String id, String city) {
        super();
        this.id = id;
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address [id=" + id + ", city=" + city + "]";
    }
}
