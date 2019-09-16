package com.padcmyanmar.padc9.restaurant_application.adapters;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.padcmyanmar.padc9.restaurant_application.Delegate.DetailMenuTabDelegate;
import com.padcmyanmar.padc9.restaurant_application.Delegate.DetailTabDelegate;
import com.padcmyanmar.padc9.restaurant_application.fragments.DetailMenuFragment;
import com.padcmyanmar.padc9.restaurant_application.fragments.RestaurantDetailFragment;

public class DetailTapVPAdapter extends FragmentStatePagerAdapter {
    private static DetailMenuTabDelegate menuTabDelegate;
    private static DetailTabDelegate detailsTabDelegate;

    public DetailTapVPAdapter(FragmentManager fm, DetailMenuTabDelegate menuTabDelegate,
                              DetailTabDelegate detailsTabDelegate) {
        super(fm);
        this.menuTabDelegate = menuTabDelegate;
        this.detailsTabDelegate = detailsTabDelegate;
    }

    @Override
    public Fragment getItem(int item) {
        switch (item){
            case 0 : return new RestaurantDetailFragment(detailsTabDelegate);
            case 1 : return new DetailMenuFragment(menuTabDelegate);
            case 2 : return new RestaurantDetailFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0 : return "DETAILS";
            case 1 : return "MENU";
            case 2 : return "REVIEWS";
        }
        return null;
    }
}
