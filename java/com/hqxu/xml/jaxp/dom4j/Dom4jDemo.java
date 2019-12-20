package com.hqxu.xml.jaxp.dom4j;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Dom4jDemo {
    
    //测试
    public static void main(String[] args) throws UnsupportedEncodingException, DocumentException {
        String xml = "<?xml version=\"1.0\" encoding=\"utf-8\" ?>" + 
                "<root>" + 
                "<name>George</name>" + 
                "<rows>" + 
                "<date>20181012</date>" + 
                "<dscode>ds123</dscode>" + 
                "</rows>" + 
                "<rows>" + 
                "<date>20151011</date>" + 
                "<dscode>ds003</dscode>" + 
                "</rows>" + 
                "<head>" + 
                "<token>123456</token>" + 
                "<req>1</req>" + 
                "</head>" + 
                "<body>" + 
                "<cs><req>1</req></cs>" + 
                "</body>" + 
                "</root>";
        
        System.out.println(xmlToMap(xml, "utf-8"));
        // {head=[{token=123456, req=1}], name=George, rows=[{date=20181012, dscode=ds123}, {date=20151011, dscode=ds003}], body=[{cs=[{req=1}]}]}
        
    }
    
    
    
    /**
    *
    * @param xml 要转换的xml字符串
    * @param charset 字符编码  (指定编码格式，否则按xml encoding)
    * @return  转换成map后返回结果
    * @throws UnsupportedEncodingException
    * @throws DocumentException
    */
   public static Map xmlToMap(String xml, String charset) throws UnsupportedEncodingException, DocumentException{
       //指定编码格式，否则按xml encoding
       //SAXReader reader = new SAXReader();
       //Document doc = reader.read(new ByteArrayInputStream(xml.getBytes(charset)));
       
       Document doc = DocumentHelper.parseText(xml);
       
       Element root = doc.getRootElement();
       //子节点
       List<Element> childElements = root.elements();
       Map mapEle = new HashMap();
       mapEle = getAllElements(childElements);
       return mapEle;
   }
   
   private static Map getAllElements(List<Element> childElements) {
       Map mapEle = new HashMap();
       for (Element ele : childElements) {
           // !!!如果当前元素还有子元素，则只能认为它是一个List<Map>,否则认为它是Map
           if(ele.elements().size()>0){
               // 递归
               Map map = new HashMap();
               map = getAllElements(ele.elements());
               
               if(!mapEle.containsKey(ele.getName())) {
                   // 如果还没插入过当前元素
                   // 新建一个List
                   List list = new ArrayList(); // LinkedList ?
                   list.add(map);
                   mapEle.put(ele.getName(), list);
               } else {
                   // 如果已经插入过map，则往里面的list添加元素
                   ((List) mapEle.get(ele.getName())).add(map);
               }
           } else {
               mapEle.put(ele.getName(), ele.getText());
           }
       }
       return mapEle;
   }
}
