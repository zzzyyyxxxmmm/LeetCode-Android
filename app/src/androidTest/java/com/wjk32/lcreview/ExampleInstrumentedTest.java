package com.wjk32.lcreview;

import android.content.Context;
import android.content.res.Resources;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.wjk32.lcreview.data.MySQLiteOpenHelper;
import com.wjk32.lcreview.data.Problem;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.File;
import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    MySQLiteOpenHelper mySQLiteOpenHelper;
    @Before
    public void init(){
        mySQLiteOpenHelper=new MySQLiteOpenHelper(Resources.getSystem());
    }



    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.wjk32.lcreview", appContext.getPackageName());
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
        System.out.println("test_loadDescription");
        String despath=mySQLiteOpenHelper.getDescription("Two Sum");
        System.out.println(despath);
        File file=new File("/assets/"+despath);
        System.out.println(file.toString());
    }
}
