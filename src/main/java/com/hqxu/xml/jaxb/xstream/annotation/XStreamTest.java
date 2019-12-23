package com.hqxu.xml.jaxb.xstream.annotation;

import java.util.ArrayList;
import java.util.List;

public class XStreamTest {

    
    public static void main(String[] args) {
        
        
        Root root = new Root();
        
        Head head = new Head();
        Body body = new Body();
        
        Filed filed1 = new Filed("n1", "123");
        Filed filed2 = new Filed("n2", "456");
        Filed filed3 = new Filed("n3", "789");
        List<Filed> fileds = new ArrayList<Filed>();
        fileds.add(filed1);
        fileds.add(filed2);
        fileds.add(filed3);
        head.setFileds(fileds);
        
        
        User u1 = new User("01", "n1", "29");
        User u2 = new User("02", "n1", "29");
        User u3 = new User("03", "n1", "29");
        User u4 = new User("04", "n1", "29");
        List<User> user1 = new ArrayList<>();
        List<User> user2 = new ArrayList<>();
        user1.add(u1);
        user1.add(u2);
        user2.add(u3);
        user2.add(u4);
        
        Users us1 = new Users();
        us1.setUser(user1);
        us1.setName("usname1");
        Users us2 = new Users();
        us2.setUser(user2);
        us2.setName("usname2");
        List<Users> users = new ArrayList<>();
        users.add(us1);
        users.add(us2);
        body.setUsers(users);
        
        root.setBody(body);
        root.setHead(head);
        
        
        
        
        // obj to xml
        String xml = XstreamUtil.beanToXml(root);
        System.out.println(xml);
        
        
        // xml to obj
        System.out.println(XstreamUtil.xmlToBean(xml, Root.class));
        
        
    }
    
}
