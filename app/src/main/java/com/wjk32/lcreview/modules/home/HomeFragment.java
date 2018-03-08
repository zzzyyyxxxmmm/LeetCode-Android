package com.wjk32.lcreview.modules.home;

import android.content.Intent;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.wjk32.lcreview.R;
import com.wjk32.lcreview.base.BaseFragment;
import com.wjk32.lcreview.data.MySQLiteOpenHelper;
import com.wjk32.lcreview.data.Problem;
import com.wjk32.lcreview.modules.ProblemDetails.ProblemDetailsActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.wjk32.lcreview.modules.ProblemDetails.ProblemDetailsActivity.EXTRA_PROBLEM_TITLE;
import static dagger.internal.Preconditions.checkNotNull;

/**
 * Created by wjk32 on 1/27/2018.
 */

public class HomeFragment extends BaseFragment implements ProblemsContract.View{


    @BindView(R.id.recycleview_problem)
    RecyclerView recyclerView;

    MySQLiteOpenHelper helper;

    private ProblemsContract.Presenter presenter;

    private ProblemAdapter problemAdapter;
    @Override
    public void setPresenter(@NonNull ProblemsContract.Presenter presenter) {
        this.presenter=checkNotNull(presenter);
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.difficulty_menu, menu);
        inflater.inflate(R.menu.filter_tasks,menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView =
                (SearchView) MenuItemCompat.getActionView(searchItem);
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter=new ProblemsPresenter(this,getResources());
        problemAdapter = new ProblemAdapter(new ArrayList<Problem>(0), mItemListener);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root=inflater.inflate(R.layout.problemsfragment,container,false);
        ButterKnife.bind(this,root);

        recyclerView.setHasFixedSize(true);

        recyclerView.setAdapter(problemAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());


        setHasOptionsMenu(true);
        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.start();
    }

    @Override
    public void showProblems(List<Problem> problems) {
        problemAdapter.updateData(problems);
    }

    @Override
    public void showProblemDetails(String title) {
        Intent intent = new Intent(getContext(), ProblemDetailsActivity.class);
        intent.putExtra(ProblemDetailsActivity.EXTRA_PROBLEM_TITLE,title);
        startActivity(intent);
    }

    ProblemItemListener mItemListener = new ProblemItemListener() {
        @Override
        public void onProblemClick(Problem clickedTask) {
            presenter.openProblemDetails(clickedTask);
        }

        @Override
        public void onFavoriteTaskClick(Problem favoriteTask) {

        }
    };



    public interface ProblemItemListener {

        void onProblemClick(Problem clickedTask);

        void onFavoriteTaskClick(Problem favoriteTask);
    }



}
