package com.gaosi.libjava;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Created by mrz on 2020/8/7.
 */
public class RunParcer {
    static String Key16 = "0123456789012345";
    static String IV16 = "0123456789012345";

    public static void main(String[] args) {
        LoganParser loganParser = new LoganParser(Key16.getBytes(), IV16.getBytes());
        File destFile = new File("/Users/lianhua/Downloads/xxxxxxxx.txt");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(destFile);
            FileInputStream fileInputStream = new FileInputStream(new File("/Users/lianhua/Downloads/2b7bfc7179c9473c9e5ee9ca03e76bcc.copy"));
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            loganParser.parse(bufferedInputStream,fileOutputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
}
