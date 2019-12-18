package com.hqxu.xml.jaxb.xstream.annotation;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@XStreamAlias("root")
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Root {
    private Head head;
    private Body body;
}
