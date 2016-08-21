package com.test;

import com.kevin.util.Base64Util;
import com.kevin.util.Base64FileUtil;
import org.junit.Test;

/**
 * Created by Kevin on 2016/8/20.
 */
public class Base64Test {
    private final String originalFile = "C:\\temp\\A5.pdf";
    private final String tragetlFile6 = "C:\\temp\\6666.pdf";
    private final String tragetlFile8 = "C:\\temp\\8888.pdf";

    @Test
    public void java6Base64Test() {
        String base64String = Base64Util.fileToBase64(originalFile);
        System.out.println(base64String);
        Base64Util.base64ToFile(base64String,tragetlFile6);
    }

    @Test
    public void java8Base64Test() {
        String base64String = Base64FileUtil.fileToBase64(originalFile);
        System.out.println(base64String);
        Base64FileUtil.base64ToFile(base64String,tragetlFile8);
    }
}
