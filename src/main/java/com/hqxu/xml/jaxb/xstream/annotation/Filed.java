package com.hqxu.xml.jaxb.xstream.annotation;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.extended.ToAttributedValueConverter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@XStreamConverter(value=ToAttributedValueConverter.class, strings={"value"})
@XStreamAlias("filed")
public class Filed {
    @XStreamAsAttribute
    private String name;
    private String value;
}
