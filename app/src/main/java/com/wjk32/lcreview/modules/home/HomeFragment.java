package com.wjk32.lcreview.modules.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wjk32.lcreview.R;
import com.wjk32.lcreview.base.BaseFragment;

/**
 * Created by wjk32 on 1/27/2018.
 */

public class HomeFragment extends BaseFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root=inflater.inflate(R.layout.problemsfragment,container,false);
        return root;
    }
}
