package com.ajayshrma.botomnavigation;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.ajayshrma.botomnavigation.fragments.frag1;
import com.ajayshrma.botomnavigation.fragments.frag2;
import com.ajayshrma.botomnavigation.fragments.frag3;

public class PageAdapter extends FragmentPagerAdapter {

    int tabcount;

    public PageAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        tabcount=behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position)
    {
        switch (position)
        {
            case 0 : return new frag1();
            case 1 : return new frag2();
            case 2 : return new frag3();
            default: return null;
        }

    }

    @Override
    public int getCount() {
        return tabcount;
    }
}
