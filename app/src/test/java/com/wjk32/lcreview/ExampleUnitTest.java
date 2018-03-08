package com.wjk32.lcreview;

import com.wjk32.lcreview.data.Problem;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {


    ArrayList<Problem> problemArrayList=new ArrayList<>();
    @Test
    public void addition_isCorrect() throws Exception {
        for(int i=1;i<=20;i++){
        }
        for(Problem i:problemArrayList){
            System.out.println(i.title);
        }
    }
}