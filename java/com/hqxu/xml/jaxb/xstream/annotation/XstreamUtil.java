package com.hqxu.xml.jaxb.xstream.annotation;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * xstream-1.4.9
 *
 */
public class XstreamUtil {

    public static String beanToXml(Object obj) {
        XStream xstream = new XStream(new DomDriver());
        xstream.autodetectAnnotations(true);
        String xml = xstream.toXML(obj);
        return xml;
    }
    
    
    @SuppressWarnings("unchecked")
    public static <T> T xmlToBean(String xml, Class<T> clazz) {
        XStream xstream = new XStream(new DomDriver());
        xstream.autodetectAnnotations(true);
        xstream.processAnnotations(clazz); // reflect
        xstream.ignoreUnknownElements(); //ignore
        
        T obj = (T) xstream.fromXML(xml);
        return obj;
    }
    
    
}
