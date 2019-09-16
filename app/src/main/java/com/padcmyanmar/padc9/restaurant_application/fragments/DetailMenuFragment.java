package com.padcmyanmar.padc9.restaurant_application.fragments;


import android.annotation.SuppressLint;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import com.padcmyanmar.padc9.restaurant_application.Delegate.DetailMenuTabDelegate;
import com.padcmyanmar.padc9.restaurant_application.R;


import butterknife.ButterKnife;


public class DetailMenuFragment extends Fragment {

    private DetailMenuTabDelegate menuTabDelegate;

    public DetailMenuFragment(){}

    @SuppressLint("ValidFragment")
    public DetailMenuFragment(DetailMenuTabDelegate menuTabDelegate) {
        this.menuTabDelegate = menuTabDelegate;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail_menu, container, false);
        ButterKnife.bind(this, view);
        menuTabDelegate.onTabMenuItem(getContext(), view);
        return view;
    }

}
