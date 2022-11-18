package com.example.flxvay.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.flxvay.Fragments.SelectColorFragment;
import com.example.flxvay.Fragments.SelectSizeFragment;

public class ProductDetailsAdapter extends FragmentPagerAdapter {
    int totalTabs;

    public ProductDetailsAdapter(@NonNull FragmentManager fm, int totalTabs) {
        super(fm);
        this.totalTabs = totalTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                SelectSizeFragment SelectSizeFragments = new SelectSizeFragment();
                return SelectSizeFragments;

            case 1:
                SelectColorFragment SelectColorFragments = new SelectColorFragment();
                return SelectColorFragments;

            default:

                return null;
        }

    }

    @Override
    public int getCount() {
        return totalTabs;
    }
}
