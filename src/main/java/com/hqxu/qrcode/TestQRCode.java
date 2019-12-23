package com.hqxu.qrcode;

import java.io.File;

public class TestQRCode {
    public static void main(String[] args) throws Exception {
        String imgPath = "二维码.png";
        String content = "\n\r我是露露，我是猪~~我要起床了~~~\n\r";
        String logo = "二维码logo.jpg";
        //加密：文字信息->二维码
        ZXingUtil.encodeImg(imgPath, "png",content, 430, 430,logo);
        //解密：二维码  ->文字信息
        ZXingUtil.decodeImg(new File(imgPath));
    }
}