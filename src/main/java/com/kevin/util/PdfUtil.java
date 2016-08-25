package com.kevin.util;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfCopy;
import com.itextpdf.text.pdf.PdfImportedPage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

/**
 * Use for processing pdf document. Dependent on itext-4.2.2.jar.<br/>
 * Make sure the itext jar is in your project.
 * version:1.2
 * <p>
 * Created by Kevin on 2016/8/16.<br/>
 * Last Update Time 2016/8/25.
 */
public class PdfUtil {

    /**
     * Merge multiple PDF Files to one.<br/>
     * The save path of the merged file will be same of the first file in the array.
     * @param files  Array of the PDF file's paths
     * @return if merge successfully,return the path of the merged file,or return null.
     * @throws IOException
     * @throws DocumentException
     */
    public static String mergePdfFiles(String[] files) throws IOException, DocumentException {
        return mergePdfFiles(files, "");
    }

    /**
     * Merge multiple PDF Files to one.<br/>
     * The save path of the merged file is specified by savePath.<br/>
     * @param files Array of the PDF file's paths.
     * @param savePath save path of the merged file. If the save path do not contains the file name of the merged file, it will be named by uuid.
     * @return if merge successfully,return the path of the merged file,or return null.
     * @throws IOException
     * @throws DocumentException
     */
    public static String mergePdfFiles(String[] files, String savePath) throws IOException, DocumentException{
        if (files == null|| files.length <= 0) {
            throw new IllegalArgumentException("The files array is null.");
        }
        for (String file : files) {
            if (file == null || !new File(file).exists()) {
                throw new IllegalArgumentException("The file: " + file + " does not exists.");
            }
        }
        if (savePath == null || "".equals(savePath)) {
            int lastIndex = files[0].lastIndexOf("/") >= files[0].lastIndexOf("\\") ? files[0].lastIndexOf("/") : files[0].lastIndexOf("\\");
            savePath = files[0].substring(0, lastIndex);
        }
        File saveFile = new File(savePath);
        if (savePath.contains(".pdf")) {
            File parentFile = saveFile.getParentFile();
            if (!parentFile.exists()) {
                if (!parentFile.mkdirs()) {
                    throw new IllegalArgumentException("The savePath: " + savePath + " does not exists.");
                }
            }
        } else {
            if (!saveFile.exists()) {
                if (!saveFile.mkdirs()) {
                    throw new IllegalArgumentException("The savePath: " + savePath + " does not exists.");
                }
            }
            savePath = savePath + "/" + UUID.randomUUID() + ".pdf";
        }
        try {
            Document document = new Document(new PdfReader(files[0]).getPageSize(1));
            PdfCopy copy = new PdfCopy(document, new FileOutputStream(savePath));
            document.open();
            for (String file : files) {
                PdfReader reader = new PdfReader(file);
                int n = reader.getNumberOfPages();
                for (int j = 1; j <= n; j++) {
                    document.newPage();
                    PdfImportedPage page = copy.getImportedPage(reader, j);
                    copy.addPage(page);
                }
            }
            document.close();
            return savePath;
        } catch (IOException e) {
           throw e;
        } catch (DocumentException e) {
            throw e;
        }
    }

}
