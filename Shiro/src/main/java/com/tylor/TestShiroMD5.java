package com.tylor;

import org.apache.shiro.crypto.hash.Md5Hash;

public class TestShiroMD5 {
    public static void main(String[] args) {
        Md5Hash md5Hash1 = new Md5Hash("123");
        System.out.println(md5Hash1.toString());
        Md5Hash md5Hash2 = new Md5Hash("123","tylor*#");
        System.out.println(md5Hash2.toString());
        Md5Hash md5Hash3 = new Md5Hash("123","tylor*#",1024);
        System.out.println(md5Hash3.toString());
    }
}
