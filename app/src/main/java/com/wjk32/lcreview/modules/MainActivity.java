package com.wjk32.lcreview.modules;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.wjk32.lcreview.R;
import com.wjk32.lcreview.modules.favorite.FavoriteFragment;
import com.wjk32.lcreview.modules.home.HomeFragment;

public class MainActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initial FragmentManger
        fragmentManager=getSupportFragmentManager();

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();



        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }



    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    changeFragment(new HomeFragment(),false);
                    return true;
                case R.id.navigation_dashboard:
                    changeFragment(new FavoriteFragment(),false);
                    return true;
                case R.id.navigation_notifications:
                    return true;
            }
            return false;
        }
    };


    public void changeFragment(Fragment fragment, boolean isInit){
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        transaction.replace(R.id.main_content,fragment);
        if(!isInit){
            transaction.addToBackStack(null);
        }
        transaction.commit();

    }


}
