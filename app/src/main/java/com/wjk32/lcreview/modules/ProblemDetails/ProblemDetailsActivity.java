package com.wjk32.lcreview.modules.ProblemDetails;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.widget.TextView;

import com.wjk32.lcreview.R;
import com.wjk32.lcreview.data.MySQLiteOpenHelper;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by wjk32 on 2/16/2018.
 */

public class ProblemDetailsActivity extends AppCompatActivity {

    public static final String EXTRA_PROBLEM_TITLE = "preblem_title";


    @BindView(R.id.description) TextView textView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.problemdetails);
        ButterKnife.bind(this);
        MySQLiteOpenHelper mySQLiteOpenHelper=new MySQLiteOpenHelper();
        String title=getIntent().getStringExtra(EXTRA_PROBLEM_TITLE);
        System.out.println(title);
        String htmlpath=mySQLiteOpenHelper.getDescription(title);
        try{

            InputStream is = getAssets().open(htmlpath);

            String text = readTextFromSDcard(is);

            textView.setText(Html.fromHtml(text));
        }catch (Exception e){

        }
    }

    private String readTextFromSDcard(InputStream is) throws Exception {
        InputStreamReader reader = new InputStreamReader(is);
        BufferedReader bufferedReader = new BufferedReader(reader);
        StringBuffer buffer = new StringBuffer("");
        String str;
        while ((str = bufferedReader.readLine()) != null) {
            buffer.append(str);
            buffer.append("\n");
        }
        return buffer.toString();
    }
}
