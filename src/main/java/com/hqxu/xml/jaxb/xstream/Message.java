package com.hqxu.xml.jaxb.xstream;

import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import com.thoughtworks.xstream.converters.basic.BooleanConverter;

@XStreamAlias("message")
public class Message {

    @XStreamAlias("type")
    private int messageType;

    @XStreamImplicit(itemFieldName="part")
    private List<String> content;
    
    @XStreamConverter(value=BooleanConverter.class, booleans={false}, strings={"yes", "no"})
    private boolean important;

    @XStreamConverter(SingleValueCalendarConverter.class)
    private Calendar created = new GregorianCalendar();

    public Message(int messageType, String... content) {
        this.messageType = messageType;
        this.content = Arrays.asList(content);
    }

}