package com.wjk32.lcreview;
import android.content.res.Resources;

import com.wjk32.lcreview.data.MySQLiteOpenHelper;
import com.wjk32.lcreview.data.Problem;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
/**
 * Created by wjk32 on 2/15/2018.
 */

public class test_db {
    MySQLiteOpenHelper mySQLiteOpenHelper;
    @Before
    public void init(){
        mySQLiteOpenHelper=new MySQLiteOpenHelper(Resources.getSystem());
    }


    @Test
    public void test_loadProblems(){

        ArrayList<Problem> problemArrayList=mySQLiteOpenHelper.getProblems();

        for(Problem problem : problemArrayList){
            System.out.println(problem.toString());
        }

    }

    @Test
    public void test_loadDescription(){
        String despath=mySQLiteOpenHelper.getDescription("Two Sum");
        System.out.println(despath);
        File file=new File("/assets/"+despath);
        System.out.println(file.toString());
    }
}
