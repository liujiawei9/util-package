package com.kevin.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

/**
 * This util is use for converting between Base64 string and file.<br/>
 * Dependent on java.util.Base64.<br/>
 * version:1.0
 * <p>
 * Created by Kevin on 2016/8/20.<br/>
 * Last Update Time 2016/8/22.
 *
 * @see java.util.Base64
 * @since 1.8
 */
public class Base64FileUtil {

    /**
     * Convert file to Base64 string
     *
     * @param filePath the path of the file
     * @return Base64 String
     * @throws IOException
     */
    public static String fileToBase64(String filePath) throws IOException {
        byte[] data = null;
        InputStream in = null;
        try {
            in = new FileInputStream(filePath);
            data = new byte[in.available()];
            in.read(data);
        } finally {
            if (in != null) {
                in.close();
            }
        }
        return encode(data);
    }

    /**
     * Convert Base64 string to file
     *
     * @param base64   Base64 string
     * @param savePath the save path of the file converts from Base64 string
     * @throws IOException
     */
    public static void base64ToFile(String base64, String savePath) throws IOException {
        byte[] bytes = decode(base64);
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(savePath);
            out.write(bytes);
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    public static String encode(byte[] data) {
        return Base64.getEncoder().encodeToString(data);
    }

    public static byte[] decode(String base64) {
        return Base64.getDecoder().decode(base64);
    }
}
