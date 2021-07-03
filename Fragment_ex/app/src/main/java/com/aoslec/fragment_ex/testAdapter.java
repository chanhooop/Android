package com.aoslec.fragment_ex;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class testAdapter extends FragmentStateAdapter {

    public testAdapter(FragmentManager fragmentManager, Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0 :
                return new testfragment1();
        }

        return new testfragment2();
    }

    @Override
    public int getItemCount() { return 2; }

}

