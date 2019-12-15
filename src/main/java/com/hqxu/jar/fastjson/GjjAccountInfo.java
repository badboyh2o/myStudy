package com.hqxu.jar.fastjson;

import java.util.List;

public class GjjAccountInfo {
    
    private List<GjjAccountInfoHead> head;
    private List<GjjAccountInfoBody> body;
    
    
    public List<GjjAccountInfoHead> getHead() {
        return head;
    }
    public void setHead(List<GjjAccountInfoHead> head) {
        this.head = head;
    }
    public List<GjjAccountInfoBody> getBody() {
        return body;
    }
    public void setBody(List<GjjAccountInfoBody> body) {
        this.body = body;
    }
    @Override
    public String toString() {
        return "{head=" + head + ", body=" + body + "}";
    }
    
    
    

}
