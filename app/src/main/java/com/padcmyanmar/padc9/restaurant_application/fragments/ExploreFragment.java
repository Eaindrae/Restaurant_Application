package com.padcmyanmar.padc9.restaurant_application.fragments;


import android.content.Context;
import android.os.Bundle;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.padcmyanmar.padc9.restaurant_application.Delegate.RestaurantDelegate;
import com.padcmyanmar.padc9.restaurant_application.R;
import com.padcmyanmar.padc9.restaurant_application.activities.MainActivity;
import com.padcmyanmar.padc9.restaurant_application.adapters.RecyclerListAdapter;
import com.padcmyanmar.padc9.restaurant_application.data.model.RestaurantModel;
import com.padcmyanmar.padc9.restaurant_application.data.vos.RestaurantVO;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ExploreFragment extends Fragment {

    @BindView(R.id.rv_restaurants)
    RecyclerView restaurantList;

    RecyclerListAdapter adapter;
    LinearLayoutManager layoutManager;
    RestaurantDelegate delegate;

    @BindView(R.id.et_layout)
    LinearLayout etLayout;

    @BindView(R.id.et_search)
    EditText etSearch;

    public ExploreFragment() {
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
        View view = inflater.inflate(R.layout.fragment_explore, container, false);
        ButterKnife.bind(this,view);
        adapter = new RecyclerListAdapter(delegate);
        layoutManager = new LinearLayoutManager(view.getContext());
        restaurantList.setLayoutManager(layoutManager);
        restaurantList.setAdapter(adapter);
        etSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etLayout.setVisibility(View.VISIBLE);
            }
        });

        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                List<RestaurantVO> houseVoList = MainActivity.restaurantModel.filterHouse(s.toString());
                adapter.setNewData(houseVoList);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        MainActivity.restaurantModel.getRestaurants( new RestaurantModel.RestaurantModelDelegates() {
            @Override
            public void onSuccess(List<RestaurantVO> houseVoList) {
                adapter.setNewData(houseVoList);

            }

            @Override
            public void onFailure(String errMessage) {
                delegate.showErrorSnack(errMessage);
            }
        });
        return view;
    }

}
