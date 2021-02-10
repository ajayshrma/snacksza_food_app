package com.ajayshrma.botomnavigation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.pm.ActivityInfo;
import android.os.Bundle;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class Order_TabLayout extends AppCompatActivity {
TabLayout tabLayout;
TabItem tabItem1,tabItem2,tabItem3;
ViewPager viewPager;
    PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order__tab_layout);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        tabLayout=findViewById(R.id.tablayout1);
        tabItem1=findViewById(R.id.tab1);
        tabItem2=findViewById(R.id.tab2);
        tabItem3=findViewById(R.id.tab3);
        viewPager=findViewById(R.id.vpager);


           pagerAdapter=new PageAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
           viewPager.setAdapter(pagerAdapter);


        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if (tab.getPosition()==0 || tab.getPosition()==1 || tab.getPosition()==2)
                    pagerAdapter.notifyDataSetChanged();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }
}