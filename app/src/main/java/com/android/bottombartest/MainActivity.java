package com.android.bottombartest;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {



    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    changeFragment(R.id.navigation_home);
                    return true;
                case R.id.navigation_dashboard:
                    changeFragment(R.id.navigation_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    changeFragment(R.id.navigation_notifications);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        changeFragment(R.id.navigation_home);
    }

    private void changeFragment(int position) {

        Fragment newFragment = null;

        if (position == R.id.navigation_home) {
            newFragment = new BlankFragment();
        } else if (position == R.id.navigation_dashboard ) {
            newFragment = new BlankFragment2();
        } else if(position == R.id.navigation_notifications){
            newFragment = new BlankFragment3();
        }else {
            throw new RuntimeException("Error with fragments");
        }

        getFragmentManager().beginTransaction().replace(
                R.id.fragmentContainer, newFragment)
                .commit();
    }

}
