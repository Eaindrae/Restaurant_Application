package com.padcmyanmar.padc9.restaurant_application.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.padcmyanmar.padc9.restaurant_application.R;
import com.padcmyanmar.padc9.restaurant_application.adapters.RecyclerListAdapter;
import com.padcmyanmar.padc9.restaurant_application.data.vos.RestaurantVO;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.github.aungkothet.padc.assignment6.R;
import io.github.aungkothet.padc.assignment6.adapters.RestaurantMenuRecyclerAdapter;
import io.github.aungkothet.padc.assignment6.data.vos.RestaurantVo;


public class DetailMenuFragment extends Fragment {


    @BindView(R.id.detail_menu_list)
    RecyclerView menuList;

    public DetailMenuFragment() {
        // Required empty public constructor
    }

    RestaurantVO restaurantVo;

    private static final String BE_RESTAURNAT = "bundleExtra";


    public static Fragment newInstance(RestaurantVO restaurantVo){
        Bundle bundle = new Bundle();
        bundle.putSerializable(BE_RESTAURNAT,restaurantVo);
        Fragment fragment = new DetailMenuFragment();
        fragment.setArguments(bundle);
        return fragment;
    }


//    public void setRestaurantVo(RestaurantVo restaurantVo) {
//        System.out.println("received data");
//        this.restaurantVo = restaurantVo;
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detail_menu, container, false);
        ButterKnife.bind(this,view);
        restaurantVo = (RestaurantVO) getArguments().getSerializable(BE_RESTAURNAT);
        RestaurantMenuRecyclerAdapter adapter = new RestaurantMenuRecyclerAdapter();
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        menuList.setLayoutManager(layoutManager);
        menuList.setAdapter(adapter);
        adapter.setNewData(restaurantVo.getMenus());
        return  view;
    }

}
