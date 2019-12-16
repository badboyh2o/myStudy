package com.hqxu.xml.jaxb.xstream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.thoughtworks.xstream.XStream;


/**
 * xstream 
 * 1. null 值属性不输出！
 * 2. 注意属性定义的类型和setter设置的属性类型一致
 */
public class XstreamUtil {

    public static void main(String[] args) {
        // 实例化
        XStream xstream = new XStream();
        //XStream xstream = new XStream(new StaxDriver()); //不换行，适合网络传输
        // 启用注解
        xstream.autodetectAnnotations(true);
        Message msg = new Message(15, "abc", "hgh");
        
        // obj to xml
        String xml = xstream.toXML(msg);
        System.out.println(xml);
        
        //输出无格式的XML
        //StringWriter writer = new StringWriter();
        //xstream.marshal(msg,new CompactWriter(writer));
        //System.out.println(writer.toString());
        
        
        // Bean
        Address addr1 = new Address("001", "guagnzhou");
        Address addr2 = new Address("002", "dg");
        List<Address> addrs = new ArrayList<Address>();
        addrs.add(addr1);
        addrs.add(addr2);
        
        List<String> strlist = new ArrayList<String>();
        strlist.add("basketball");
        strlist.add("playball");
        
        Map<String, String> fruitmap = new HashMap<String, String>();
        fruitmap.put("1", "apple");
        
        Person p = new Person( "xuhq", strlist,addrs);
        p.setFirstname(null);
        p.setFruits(fruitmap);
        
        // bean to xml
        String xml2 = xstream.toXML(p);
        System.out.println(xml2);
        // xml to bean
        Person p2 = (Person) xstream.fromXML("<?xml version=\"1.0\" encoding=\"utf-8\" ?>" + xml2);
        System.out.println(p2);
    }    
}
