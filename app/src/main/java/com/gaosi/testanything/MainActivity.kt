package com.gaosi.testanything

import android.content.Context
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.annotation.IntRange
import androidx.appcompat.app.AppCompatActivity
import com.dianping.logan.Logan
import com.dianping.logan.LoganConfig
import com.dianping.logan.SendLogRunnable
import com.fatangare.logcatviewer.utils.LogcatViewer
import com.zy.logcat.LogCatControl
import java.io.File
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    var count  = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init(this)
        findViewById<View>(R.id.tv_).setOnClickListener {
            Toast.makeText(this@MainActivity, "asdasdasd", Toast.LENGTH_LONG).show()
//清除dialog
            count++
            Log.w("makeText","makeText"+count)
            LogCatControl.getBuilder(this).clear();
        }
        findViewById<View>(R.id.fl_title_overlay).setOnClickListener {
            //                Toast.makeText(MainActivity.this,"asdasdasd",Toast.LENGTH_LONG).show();
//            generateLog()
            //显示dialog
//            LogCatControl.getBuilder(this)
//                    .setTitle("自定义标题")
//                    .setSearchContent("自定义搜索内容")
//                    .setSearchTag("自定义Tag")
//                    .setShowGrade(3) //设置显示级别:0 所有，1 系统，2 警告,3 错误
//                    .show();
            LogcatViewer.showLogcatLoggerView(this);

        }
        val dates = getDates(1)
        findViewById<View>(R.id.getLog).setOnClickListener {
            //                Toast.makeText(MainActivity.this,"asdasdasd",Toast.LENGTH_LONG).show();
            Toast.makeText(this@MainActivity, "getLog", Toast.LENGTH_LONG).show()
            Logan.s(dates.toTypedArray(),object: SendLogRunnable() {
                override fun sendLog(logFile: File?) {
                    Log.i("sendLog","================="+logFile?.path)
                }

            })

//            val storageDir = Environment.getExternalStorageDirectory()
//            if (!storageDir.exists()) {
//                if (!storageDir.mkdir()) {
//                    throw IOException()
//                }
//            }
//            val file = File(storageDir, "Logfiletesttttttttt")
//            val out = FileOutputStream(file)
//            iv_icon!!.drawingCache.compress(Bitmap.CompressFormat.JPEG, 100, out)
//            out.flush()
//            out.close()
//            thread {
//                while (true){
//                    Thread.sleep(1000)
//                    Log.w("makeText","makeText"+count)
//                }
//            }.start()




        }
        object : Thread() {
            override fun run() {
                super.run()
                while (true) {
                    Thread.sleep(1000)
                    Log.w("makeText", "makeText" + count)
                }
//                Thread.sleep(1000)
//                Log.w("makeText","makeText"+count)
            }
        }.start()
//        while (true) {
//            Thread.sleep(1000)
//            Log.w("makeText", "makeText" + count)
//        }
    }

    public fun generateLog() {
        Log.i("asd", "asdasdas")
        Toast.makeText(this@MainActivity, "add log", Toast.LENGTH_LONG).show()
        for (i in 0 until 100) {
            Log.i("Logan", "aaaaaaaaaaaaaaa" + i)
            Logan.w("aaaaaaaaaaaaaaa" + i, 2)
        }
    }

    fun init(context: Context) {
        val Key16 = "0123456789012345"
        val IV16 = "0123456789012345"

//        var externalFilesDir = context.getExternalFilesDir(null)
        var externalFilesDir = Environment.getExternalStorageDirectory()
//
//        if (externalFilesDir == null) {
//            externalFilesDir = Environment.getExternalStorageDirectory()
//        }
        val path = externalFilesDir!!.path + "/1"
        Log.i("externalFilesDir", path)
        val config = LoganConfig.Builder()
                .setCachePath(path)
                .setPath(path)
                .setEncryptKey16(Key16.toByteArray())
                .setEncryptIV16(IV16.toByteArray())
                .build()
        Logan.init(config)
        Logan.setDebug(false)
        //        start();
        Log.d("logan", "Logan.init")
        Logan.w("Logan.init", 3)
    }
    private fun getDates(@IntRange(from = 1, to = 7) dayCount: Int): ArrayList<String> {
        val formatter = SimpleDateFormat("yyyy-MM-dd")
        val now = System.currentTimeMillis()

        val today = getFormatDate(formatter, now)
        val yesterday = getFormatDate(formatter, now - 24 * 3600 * 1000L)
        val theDayBeforeYesterday = getFormatDate(formatter, now - 2 * 24 * 3600 * 1000L)
        val twoDayBeforeYesterday = getFormatDate(formatter, now - 3 * 24 * 3600 * 1000L)
        val threeDayBeforeYesterday = getFormatDate(formatter, now - 4 * 24 * 3600 * 1000L)
        val fourDayBeforeYesterday = getFormatDate(formatter, now - 5 * 24 * 3600 * 1000L)
        val fiveDayBeforeYesterday = getFormatDate(formatter, now - 6 * 24 * 3600 * 1000L)
        val strs = ArrayList<String>()
        when (dayCount) {
            1 -> strs.add(today)
            2 -> {
                strs.add(today)
                strs.add(yesterday)
            }
            3 -> {
                strs.add(today)
                strs.add(yesterday)
                strs.add(theDayBeforeYesterday)
            }
            4 -> {
                strs.add(today)
                strs.add(yesterday)
                strs.add(theDayBeforeYesterday)
                strs.add(twoDayBeforeYesterday)
            }
            5 -> {
                strs.add(today)
                strs.add(yesterday)
                strs.add(theDayBeforeYesterday)
                strs.add(twoDayBeforeYesterday)
                strs.add(threeDayBeforeYesterday)
            }
            6 -> {
                strs.add(today)
                strs.add(yesterday)
                strs.add(theDayBeforeYesterday)
                strs.add(twoDayBeforeYesterday)
                strs.add(threeDayBeforeYesterday)
                strs.add(fourDayBeforeYesterday)
            }
            7 -> {
                strs.add(today)
                strs.add(yesterday)
                strs.add(theDayBeforeYesterday)
                strs.add(twoDayBeforeYesterday)
                strs.add(threeDayBeforeYesterday)
                strs.add(fourDayBeforeYesterday)
                strs.add(fiveDayBeforeYesterday)
            }
            else -> strs.add(today)
        }
        return strs
    }
    private fun getFormatDate(formatter: SimpleDateFormat, today: Long): String {
        return formatter.format(Date(today))
    }
}
