package com.hqxu.xml.jaxb.xstream.annotation;

import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @XStreamAsAttribute
    private String id;
    private String name;
    private String age;
}
