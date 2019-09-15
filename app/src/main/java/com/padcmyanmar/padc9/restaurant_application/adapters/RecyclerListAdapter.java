package com.padcmyanmar.padc9.restaurant_application.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;


import com.padcmyanmar.padc9.restaurant_application.Delegate.RestaurantDelegate;
import com.padcmyanmar.padc9.restaurant_application.R;
import com.padcmyanmar.padc9.restaurant_application.ViewHolders.RecyclerViewHolder;
import com.padcmyanmar.padc9.restaurant_application.data.vos.RestaurantVO;

public class RecyclerListAdapter extends BaseRecyclerViewAdapter<RecyclerViewHolder, RestaurantVO> {

    private RestaurantDelegate mRestaurantDelegate;

    public RecyclerListAdapter(RestaurantDelegate ItemDelegate) {
        this.mRestaurantDelegate = ItemDelegate;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemview=LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_menu,parent,false);
        return new RecyclerViewHolder(itemview, mRestaurantDelegate);
    }


}
