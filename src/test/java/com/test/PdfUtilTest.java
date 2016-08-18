package com.test;

import com.kevin.util.PdfUtil;
import org.junit.Test;

/** PdfUtilTest
 * Created by Kevin on 2016/8/17.
 */
public class PdfUtilTest {

    private String[] pdfs = {"C:\\temp\\A5.pdf","C:\\temp\\A55.pdf"};
    private String savePath = "C:\\temp\\test\\sss\\";
    @Test
    public void testMergePdfWithoutSavePath() {
        PdfUtil.mergePdfFiles(pdfs);
    }

    @Test
    public void testMergePdfWithSavePath() {
        PdfUtil.mergePdfFiles(pdfs,savePath);
    }
}
