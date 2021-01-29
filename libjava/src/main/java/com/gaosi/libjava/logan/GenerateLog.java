//package com.gaosi.libjava.logan;
//
///**
// * Created by mrz on 2020-10-17.
// */
//public class GenerateLog {
//    public static void main(String[] args) {
//
//    }
//
//    private void  init() {
//
//        String Key16 = "0123456789012345";
//        String IV16 = "0123456789012345";
//
//        String externalFilesDir = "/Users/lianhua/Downloads/";
////        var externalFilesDir = Environment.getExternalStorageDirectory()
////
////        if (externalFilesDir == null) {
////            externalFilesDir = Environment.getExternalStorageDirectory()
////        }
//        LoganConfig config = LoganConfig.Builder()
//                .setCachePath(context.filesDir.absolutePath)
//                .setPath(externalFilesDir!!.path
//                        )
//                .setEncryptKey16(Key16.toByteArray())
//                .setEncryptIV16(IV16.toByteArray())
//                .build();
//        Logan.init(config);
//        Logan.setDebug(false);
//        //        start();
//        Logan.w("Logan.init", 3);
//    }
//}
