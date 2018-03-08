package com.wjk32.lcreview.modules.home;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wjk32.lcreview.R;
import com.wjk32.lcreview.data.Problem;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by wjk32 on 2/15/2018.
 */

public class ProblemAdapter extends RecyclerView.Adapter<ProblemAdapter.ViewHolder> {


    List<Problem> problemList;
    private HomeFragment.ProblemItemListener itemListener;

    public ProblemAdapter(ArrayList<Problem> problemList, HomeFragment.ProblemItemListener itemListener) {
        setProblemList(problemList);
        this.itemListener=itemListener;
    }
    public void updateData(List<Problem> data) {
        setProblemList(data);
        notifyDataSetChanged();
    }

    public void setProblemList(List<Problem> problemList) {
        this.problemList = problemList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.problems_item, parent, false);

        final ViewHolder viewHolder = new ViewHolder(v);
        ButterKnife.bind(viewHolder,v);
        v.findViewById(R.id.problem_title).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemListener.onProblemClick(problemList.get(viewHolder.getLayoutPosition()));
            }
        });
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.problemTitle.setText(problemList.get(position).title);
    }

    @Override
    public int getItemCount() {
        return problemList == null ? 0 : problemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.problem_title)
        TextView problemTitle;

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }


}
