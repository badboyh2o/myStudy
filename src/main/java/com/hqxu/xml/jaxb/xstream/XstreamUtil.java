package com.hqxu.xml.jaxb.xstream;

import java.util.Arrays;

import com.thoughtworks.xstream.XStream;

public class XstreamUtil {

    public static void main(String[] args) {
        // 实例化
        XStream xstream = new XStream();
        // 启用注解
        xstream.autodetectAnnotations(true);
        
        Message msg = new Message(15, "abc", "hgh");
        // obj to xml
        String xml = xstream.toXML(msg);
        System.out.println(xml);
        
        
        
        // Bean
        Person p = new Person( "xuhq", Arrays.asList("basketball","playball"),
                Arrays.asList(new Address("001", "guagnzhou"), new Address("002", "dongguan")));
        // bean to xml
        String xml2 = xstream.toXML(p);
        System.out.println(xml2);
        // xml to bean
        Person p2 = (Person) xstream.fromXML("<?xml version=\"1.0\" encoding=\"utf-8\" ?>" + xml2);
        System.out.println(p2);
    }    
}
