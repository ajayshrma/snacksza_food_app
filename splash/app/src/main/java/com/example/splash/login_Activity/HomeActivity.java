package com.example.splash.login_Activity;

import android.os.Bundle;

import com.example.splash.Home_Fragement;
import com.example.splash.Profile_fragment;
import com.example.splash.R;
import com.example.splash.Scan_fragment;
import com.example.splash.purchase_fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.MenuItem;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
    private TextView mTextMessage;

    private boolean loadfrag(Fragment which_you_want) {
        if (which_you_want != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmenthome,which_you_want)
                    .commit();
            return true;
        }
        return false;
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment which_you_want = null;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    which_you_want=new Home_Fragement();
                    break;
                case R.id.navigation_Scan:
                    which_you_want = new Scan_fragment();
                    break;
                case R.id.navigation_Purchase:
                    which_you_want = new purchase_fragment();

                    break;

                case R.id.navigation_Profile:
                    which_you_want = new Profile_fragment();

                    break;
            }
            return loadfrag(which_you_want);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        mTextMessage = findViewById(R.id.message);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
