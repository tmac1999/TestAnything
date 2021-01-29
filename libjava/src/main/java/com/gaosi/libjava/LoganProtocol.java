package com.gaosi.libjava;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @since logan-web 1.0
 */
public class LoganProtocol {

//    private static final Logger LOGGER = Logger.getLogger(LoganProtocol.class);

    private static final char ENCRYPT_CONTENT_START = '\1';

    private static final String AES_ALGORITHM_TYPE = "AES/CBC/NoPadding";

    private static AtomicBoolean initialized = new AtomicBoolean(false);

    static {
//        initialize();
    }

    public static void main(String[] args) {
        try {
            File destFile = new File("/Users/lianhua/Downloads/xxxx.txt");
            LoganProtocol loganProtocol = new LoganProtocol(new FileInputStream("/Users/lianhua/Downloads/2b7bfc7179c9473c9e5ee9ca03e76bcc.copy"), destFile);
            loganProtocol.process();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    private ByteBuffer wrap;
    private InputStream fileInputStream;
    private FileOutputStream fileOutputStream;

    public LoganProtocol(InputStream stream, File file) {
        try {
            this.fileInputStream = stream;
            fileOutputStream = new FileOutputStream(file);
        } catch (IOException e) {
//            LOGGER.error(e);
            e.printStackTrace();
        }
    }
    static String Key16 = "0123456789012345";
    static String IV16 = "0123456789012345";
    public void process() {
        LoganParser loganParser = new LoganParser(Key16.getBytes(), IV16.getBytes());
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            loganParser.parse(bufferedInputStream,fileOutputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        while (wrap.hasRemaining()) {
//            while (wrap.get() == ENCRYPT_CONTENT_START) {
//                byte[] encrypt = new byte[0];
//                try {
//                    encrypt = new byte[wrap.getInt()];
//                } catch (Exception e) {
//                    encrypt = new byte[96];
//                    e.printStackTrace();
//                }
//                System.out.println("wrap.getInt()"+encrypt.length);
//                if (!tryGetEncryptContent(encrypt) || !decryptAndAppendFile(encrypt)) {
//                    System.out.println("ERROR_DECRYPT");
//                    return ResultEnum.ERROR_DECRYPT;
//                }
//            }
//        }
        System.out.println("succsee");
    }


}