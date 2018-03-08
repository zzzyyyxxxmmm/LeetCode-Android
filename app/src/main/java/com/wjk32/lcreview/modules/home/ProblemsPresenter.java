package com.wjk32.lcreview.modules.home;

import android.content.res.Resources;
import android.widget.Toast;

import com.wjk32.lcreview.data.MySQLiteOpenHelper;
import com.wjk32.lcreview.data.Problem;

import java.util.ArrayList;

/**
 * Created by wjk32 on 2/16/2018.
 */

public class ProblemsPresenter implements ProblemsContract.Presenter{

    private final ProblemsContract.View mProblemsView;
    private final Resources resources;


    public ProblemsPresenter(ProblemsContract.View mProblemsView,Resources resources) {
        this.mProblemsView = mProblemsView;
        this.resources=resources;
        mProblemsView.setPresenter(this);
    }

    @Override
    public void start() {
        loadProblems();
    }

    @Override
    public void loadProblems() {
        MySQLiteOpenHelper mySQLiteOpenHelper=new MySQLiteOpenHelper(resources);
        ArrayList<Problem> problemArrayList=mySQLiteOpenHelper.getProblems();
        mProblemsView.showProblems(problemArrayList);
    }

    @Override
    public void openProblemDetails(Problem problem) {
        mProblemsView.showProblemDetails(problem.getTitle());
    }
}
