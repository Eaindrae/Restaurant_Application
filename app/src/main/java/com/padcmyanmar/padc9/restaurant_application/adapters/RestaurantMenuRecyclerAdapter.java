package com.padcmyanmar.padc9.restaurant_application.adapters;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.padcmyanmar.padc9.restaurant_application.R;
import com.padcmyanmar.padc9.restaurant_application.ViewHolders.RestaurantMenuViewHolder;
import com.padcmyanmar.padc9.restaurant_application.data.vos.MenuVO;



public class RestaurantMenuRecyclerAdapter extends BaseRecyclerViewAdapter<RestaurantMenuViewHolder, MenuVO> {

    @NonNull
    @Override
    public RestaurantMenuViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_restaurant_menu, viewGroup, false);
        return new RestaurantMenuViewHolder(view);
    }
}
