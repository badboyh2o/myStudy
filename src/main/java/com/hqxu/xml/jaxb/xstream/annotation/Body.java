package com.hqxu.xml.jaxb.xstream.annotation;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamImplicit;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Body {
    @XStreamImplicit(itemFieldName="users")
    private List<Users> users;
}
