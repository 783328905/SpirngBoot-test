package com.ctillnow.util;

import org.apache.commons.codec.binary.Base64;

public class Base64Util {
    public Base64Util() {
    }

    public static final String encode(String data) {
        byte[] bytes = data.getBytes();
        return encode(bytes);
    }

    public static final String encode(byte[] bytes) {
        return Base64.encodeBase64String(bytes);
    }

    public static final String decode(String encodeData) {
        byte[] bytes = Base64.decodeBase64(encodeData);
        return new String(bytes);
    }

    public static void main(String[] args) {
        String str = "djafogWJEOGJWE";
        String encodeData = encode(str);
        String decodeData = decode(encodeData);
        System.out.println(encodeData);
        System.out.println(decodeData);
    }
}
