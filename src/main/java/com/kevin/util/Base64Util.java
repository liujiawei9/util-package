package com.kevin.util;

import java.io.*;

import javax.xml.bind.DatatypeConverter;

public class Base64Util {

	public static String fileToBase64(String filePath) {
		byte[] data = null;
		try {
			InputStream in = new FileInputStream(filePath);
			data = new byte[in.available()];
			in.read(data);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return encode(data);
	}

	public static void base64ToFile(String base64,String targetPath) {
        byte[] bytes = decode(base64);
        try {
            FileOutputStream out = new FileOutputStream(targetPath);
            out.write(bytes);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	public static String encode(byte[] data) {
        return DatatypeConverter.printBase64Binary(data);
    }
	
    public static byte[] decode(String base64) {
        return DatatypeConverter.parseBase64Binary(base64);
    }
}
