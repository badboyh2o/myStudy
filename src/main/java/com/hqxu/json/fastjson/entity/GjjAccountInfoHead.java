package com.hqxu.json.fastjson.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class GjjAccountInfoHead {

    @JSONField(serialize = true, name = "Tran_ID")
    private String Tran_ID;
    private String name;
    
    
    private boolean b;
    private double d;
    private int i;
    private short s;
    private long l;
    private char c;
    private byte by;
    private float f;

    public GjjAccountInfoHead() {
        super();
    }


    //@JSONField(name="Tran_ID")
    public String getTran_ID() {
        return Tran_ID;
    }

    public void setTran_ID(String tran_ID) {
        Tran_ID = tran_ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public boolean isB() {
        return b;
    }


    public void setB(boolean b) {
        this.b = b;
    }


    public double getD() {
        return d;
    }


    public void setD(double d) {
        this.d = d;
    }


    public int getI() {
        return i;
    }


    public void setI(int i) {
        this.i = i;
    }


    public short getS() {
        return s;
    }


    public void setS(short s) {
        this.s = s;
    }


    public long getL() {
        return l;
    }


    public void setL(long l) {
        this.l = l;
    }


    public char getC() {
        return c;
    }


    public void setC(char c) {
        this.c = c;
    }


    public byte getBy() {
        return by;
    }


    public void setBy(byte by) {
        this.by = by;
    }


    public float getF() {
        return f;
    }


    public void setF(float f) {
        this.f = f;
    }


    @Override
    public String toString() {
        return "GjjAccountInfoHead [Tran_ID=" + Tran_ID + ", name=" + name + ", b=" + b + ", d=" + d + ", i=" + i
                + ", s=" + s + ", l=" + l + ", c=" + c + ", by=" + by + ", f=" + f + "]";
    }







    
    
    
}
