package com.padcmyanmar.padc9.restaurant_application.activities;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.google.android.material.tabs.TabLayout;
import com.padcmyanmar.padc9.restaurant_application.Delegate.DetailMenuTabDelegate;
import com.padcmyanmar.padc9.restaurant_application.Delegate.DetailTabDelegate;
import com.padcmyanmar.padc9.restaurant_application.Delegate.RestaurantDelegate;
import com.padcmyanmar.padc9.restaurant_application.R;
import com.padcmyanmar.padc9.restaurant_application.adapters.DetailTapVPAdapter;
import com.padcmyanmar.padc9.restaurant_application.adapters.RestaurantMenuRecyclerAdapter;
import com.padcmyanmar.padc9.restaurant_application.data.vos.MenuVO;
import com.padcmyanmar.padc9.restaurant_application.data.vos.RestaurantVO;


import java.util.List;

import butterknife.BindView;

public class DetailsActivity extends BaseActivity implements DetailMenuTabDelegate, DetailTabDelegate {

    public static final String EXTRA_RESTAURANT_ID = "eventExtra";

    int id = 0;
    RestaurantVO  restaurantVo;

    public static Intent newIntent(Context context, int eventIdExtra) {
        Intent intent = new Intent(context, DetailsActivity.class);
        intent.putExtra(EXTRA_RESTAURANT_ID, eventIdExtra);
        return intent;
    }
    @BindView(R.id.tablayout)
    TabLayout tabLayout;

    @BindView(R.id.vp_detail)
    ViewPager viewPager;

    @BindView(R.id.iv_restaurant_image)
    ImageView detailImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        id = getIntent().getIntExtra(EXTRA_RESTAURANT_ID, 0);
        restaurantVo = mRestaurantModel.getRestaurantById(id);

        Glide.with(this)
                .load(restaurantVo.getImageUrl())
                .into(detailImage);

        DetailTapVPAdapter adapter = new DetailTapVPAdapter(getSupportFragmentManager(), this, this);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }






    @Override
    public void onTabMenuItem(Context context, View view) {

        List<MenuVO> menuList = mRestaurantModel.getAllMenuByRestaurantId(id);

        //bind-view
        RecyclerView rvDetailMenu = view.findViewById(R.id.rv_detail_menu);
        rvDetailMenu.setLayoutManager(new LinearLayoutManager(context, RecyclerView.VERTICAL, false));
        RestaurantMenuRecyclerAdapter adapter = new RestaurantMenuRecyclerAdapter();
        adapter.setNewData(menuList);
        rvDetailMenu.setAdapter(adapter);
    }

    @Override
    public void onTabDetailsItem(Context context, View view) {

        TextView detailName = view.findViewById(R.id.tv_restaurant_name);
        detailName.setText(restaurantVo.getName());

        TextView textDetail = view.findViewById(R.id.tv_restaurant_detail_desc);
        textDetail.setText(restaurantVo.getDescription());

    }
}
