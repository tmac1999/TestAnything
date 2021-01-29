package com.gaosi.testanything

import android.util.Log
import com.dianping.logan.Logan
import com.dianping.logan.LoganConfig
import org.junit.Test

/**
 * Created by mrz on 2020-10-17.
 */
class MainActivityTest {

    @Test
    fun generateLog() {
        init()
        for (i in 0 until 100) {
            Log.i("Logan", "aaaaaaaaaaaaaaa" + i)
            Logan.w("aaaaaaaaaaaaaaa" + i, 2)
        }

    }
    fun init() {
        val Key16 = "0123456789012345"
        val IV16 = "0123456789012345"

        var externalFilesDir =  "/Users/lianhua/Downloads/cache/"
        var cachePath =  "/Users/lianhua/Downloads/cache/"
//        var externalFilesDir = Environment.getExternalStorageDirectory()
//
//        if (externalFilesDir == null) {
//            externalFilesDir = Environment.getExternalStorageDirectory()
//        }
        val config = LoganConfig.Builder()
                .setCachePath(cachePath)
                .setPath(externalFilesDir)
                .setEncryptKey16(Key16.toByteArray())
                .setEncryptIV16(IV16.toByteArray())
                .build()
        Logan.init(config)
        Logan.setDebug(false)
        //        start();
        Log.d("logan", "Logan.init")
        Logan.w("Logan.init", 3)
    }
}