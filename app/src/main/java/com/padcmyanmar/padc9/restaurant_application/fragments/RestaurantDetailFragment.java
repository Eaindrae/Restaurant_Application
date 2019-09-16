package com.padcmyanmar.padc9.restaurant_application.fragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.padcmyanmar.padc9.restaurant_application.Delegate.DetailTabDelegate;
import com.padcmyanmar.padc9.restaurant_application.Delegate.RestaurantDelegate;
import com.padcmyanmar.padc9.restaurant_application.R;


import com.padcmyanmar.padc9.restaurant_application.data.vos.RestaurantVO;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RestaurantDetailFragment extends Fragment {
    private static DetailTabDelegate detailsTabDelegate;

    public RestaurantDetailFragment(){}

    @SuppressLint("ValidFragment")
    public RestaurantDetailFragment(DetailTabDelegate detailsTabDelegate){
        this.detailsTabDelegate = detailsTabDelegate;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_restaurant_detail, container, false);
        ButterKnife.bind(this,view);
        detailsTabDelegate.onTabDetailsItem(getActivity(),view);
        return view;
    }
}
