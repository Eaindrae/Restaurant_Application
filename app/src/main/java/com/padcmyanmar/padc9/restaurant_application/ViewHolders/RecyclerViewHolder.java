package com.padcmyanmar.padc9.restaurant_application.ViewHolders;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import com.padcmyanmar.padc9.restaurant_application.Delegate.RestaurantDelegate;
import com.padcmyanmar.padc9.restaurant_application.R;
import com.padcmyanmar.padc9.restaurant_application.data.vos.RestaurantVO;

import org.mmtextview.components.MMTextView;



import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerViewHolder extends BaseViewHolder<RestaurantVO> {

    @BindView(R.id.tv_restaurant_name)
    TextView tvRestaurantName;

    @BindView(R.id.iv_restaurant_image)
    ImageView restaurantImage;



    @BindView(R.id.tv_rating_num)
    TextView restaurantRating;

    @BindView(R.id.rb_star)
    RatingBar ratingBar;

    @BindView(R.id.fab)
    FloatingActionButton loactionFab;

    @BindView(R.id.tv_description)
    TextView restaurantDesc;

    @BindView(R.id.btn_address)
    TextView restaurantAddress;

    private Context context;

    public RecyclerViewHolder(@NonNull View itemView,final RestaurantDelegate delegates) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        loactionFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delegates.onFabClicked(mData);
            }
        });

        itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                delegates.onTapRestaurant(mData.getId());
            }
        });
    }

    @Override
    public void bindData(RestaurantVO restaurant) {
        mData = restaurant;
        tvRestaurantName.setText(restaurant.getName());
        Glide.with(itemView)
                .load(mData.getImageUrl())
                .into(restaurantImage);
        restaurantAddress.setText(mData.getAddress());
        restaurantDesc.setText(mData.getDescription());
        restaurantRating.setText(mData.getRating());
        ratingBar.setRating(Float.parseFloat(mData.getRating()));
    }
}

