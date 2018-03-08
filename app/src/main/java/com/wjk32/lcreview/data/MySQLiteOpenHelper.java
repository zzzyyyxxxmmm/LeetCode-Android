package com.wjk32.lcreview.data;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.Html;

import com.wjk32.lcreview.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by wjk32 on 2/15/2018.
 */

public class MySQLiteOpenHelper {


    private final static String DATABASE_PATH = android.os.Environment
            .getExternalStorageDirectory().getAbsolutePath()
            + "/leetcode";
    private final static String DATABASE_FILENAME = "leetcode.db";

    public static SQLiteDatabase db;
    Resources resources;


    public MySQLiteOpenHelper() {
    }

    public MySQLiteOpenHelper(Resources resources) {
        this.db=openDatabase(resources);
    }


    public SQLiteDatabase getSqLiteDatabase() {
        return db;
    }

    public String getDescription(String title){
        if(db==null){
            return "database is empty";
        }
        Cursor c=db.rawQuery("select path from description where description.title=\""+title+"\"",null);
        while(c.moveToNext()){
            return c.getString(c.getColumnIndex("path")).substring(13);
        }
        return "no description";
    }




    public ArrayList<Problem> getProblems(){
        ArrayList<Problem> problemArrayList=new ArrayList<>();
        if(db==null){
            System.out.println("database is empty");
        }
        Cursor c=db.rawQuery("select * from problem",null);
        while(c.moveToNext()){
            Problem problem=new Problem(
                c.getInt(c.getColumnIndex("id")),c.getString(c.getColumnIndex("title")),
                    c.getString(c.getColumnIndex("slug")),c.getInt(c.getColumnIndex("difficulty")),
                    c.getInt(c.getColumnIndex("paid_only")),c.getString(c.getColumnIndex("status")),
                    c.getInt(c.getColumnIndex("total_acs")),c.getInt(c.getColumnIndex("total_submitted")),
                    c.getInt(c.getColumnIndex("favorite"))
            );
            problemArrayList.add(problem);
        }
        return problemArrayList;
    }

    public SQLiteDatabase openDatabase(Resources resources) {
        try {
            // 获得dictionary.db文件的绝对路径
            String databaseFilename = "/sdcard/leetcode"+ "/" + DATABASE_FILENAME;

            System.out.println("数据库存放目录为:"+databaseFilename);
            File dir = new File(DATABASE_PATH);
            // 如果/sdcard/dictionary目录中存在，创建这个目录
            if (!dir.exists())
                dir.mkdir();
            // 如果在/sdcard/dictionary目录中不存在
            // dictionary.db文件，则从res\raw目录中复制这个文件到
            // SD卡的目录（/sdcard/dictionary）
            if (!(new File(databaseFilename)).exists()) {
                // 获得封装dictionary.db文件的InputStream对象
                InputStream is = resources.openRawResource(
                        R.raw.leetcode);
                FileOutputStream fos = new FileOutputStream(databaseFilename);
                byte[] buffer = new byte[8192];
                int count = 0;
                // 开始复制dictionary.db文件
                while ((count = is.read(buffer)) > 0) {
                    fos.write(buffer, 0, count);
                }

                fos.close();
                is.close();
            }
            // 打开/sdcard/dictionary目录中的dictionary.db文件
            SQLiteDatabase database = SQLiteDatabase.openOrCreateDatabase(
                    databaseFilename, null);
            return database;
        } catch (Exception e) {
        }
        return null;
    }

}