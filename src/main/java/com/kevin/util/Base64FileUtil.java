package com.kevin.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

public class Base64FileUtil {

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
        return Base64.getEncoder().encodeToString(data);
    }
	
    public static byte[] decode(String base64) {
        return Base64.getDecoder().decode(base64);
    }
}
