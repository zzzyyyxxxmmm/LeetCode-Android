package com.wjk32.lcreview.modules.home;

import android.view.View;

import com.wjk32.lcreview.base.BasePresenter;
import com.wjk32.lcreview.base.BaseView;
import com.wjk32.lcreview.data.Problem;

import java.util.List;

/**
 * Created by wjk32 on 2/16/2018.
 */

public interface ProblemsContract {


    interface View extends BaseView<Presenter>{
        void showProblems(List<Problem> problems);
        void showProblemDetails(String title);
    }


    interface Presenter extends BasePresenter<View>{
        void loadProblems();
        void openProblemDetails(Problem problem);
    }
}
