package com.hqxu.json.fastjson.entity;

import java.util.List;

public class GjjAccountInfoBody {

    private String zjhm;
    private List<GjjAccountInfoBodyDetail> detail;
    
    
    public String getZjhm() {
        return zjhm;
    }
    public void setZjhm(String zjhm) {
        this.zjhm = zjhm;
    }
    public List<GjjAccountInfoBodyDetail> getDetail() {
        return detail;
    }
    public void setDetail(List<GjjAccountInfoBodyDetail> detail) {
        this.detail = detail;
    }
    @Override
    public String toString() {
        return "{zjhm=" + zjhm + ", detail=" + detail + "}";
    }
    
    
    
}
