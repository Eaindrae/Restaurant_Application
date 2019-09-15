package com.padcmyanmar.padc9.restaurant_application.fragments;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.fragment.app.Fragment;


import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.padcmyanmar.padc9.restaurant_application.Delegate.RestaurantDelegate;
import com.padcmyanmar.padc9.restaurant_application.R;


import com.padcmyanmar.padc9.restaurant_application.data.vos.RestaurantVO;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RestaurantDetailFragment extends Fragment {
    @BindView(R.id.tv_restaurant_name)
    TextView restaurantName;

    @BindView(R.id.fab1)
    FloatingActionButton locationFab;

    @BindView(R.id.tv_description)
    TextView restaurantDesc;

    @BindView(R.id.tv_time)
    TextView openingHour;

    @BindView(R.id.tv_map)
    TextView mapView;

    RestaurantDelegate delegate;
    RestaurantVO restaurantVo;

    public RestaurantDetailFragment() {
        // Required empty public constructor
    }

    private static final String BE_RESTAURNAT = "bundleExtra";


    public static Fragment newInstance(RestaurantVO restaurantVO){
        Bundle bundle = new Bundle();
        bundle.putSerializable(BE_RESTAURNAT,restaurantVO);
        Fragment fragment = new RestaurantDetailFragment();
        fragment.setArguments(bundle);
        return fragment;
    }




    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        delegate = (RestaurantDelegate) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_restaurant_detail, container, false);
        ButterKnife.bind(this,view);
        restaurantVo = (RestaurantVO) getArguments().getSerializable(BE_RESTAURNAT);
        bindViewData(restaurantVo);
        mapView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delegate.onFabClicked(restaurantVo);
            }
        });

        locationFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delegate.onFabClicked(restaurantVo);
            }
        });
        return view;
    }

    private void bindViewData(RestaurantVO restaurantVo) {
        Log.d("TAG",restaurantVo.getName()+"in bindView");
        restaurantName.setText(restaurantVo.getName());
        restaurantDesc.setText(restaurantVo.getDescription());
        openingHour.setText(restaurantVo.getOpeningClosingTime().getOpeningTime() + " - "
                + restaurantVo.getOpeningClosingTime().getClosingTime());
    }
}
