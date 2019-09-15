package com.padcmyanmar.padc9.restaurant_application.activities;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.padcmyanmar.padc9.restaurant_application.Delegate.RestaurantDelegate;
import com.padcmyanmar.padc9.restaurant_application.R;
import com.padcmyanmar.padc9.restaurant_application.data.vos.RestaurantVO;


import butterknife.BindView;

public class DetailsActivity extends BaseActivity implements RestaurantDelegate {

    public static final String EXTRA_RESTAURANT_ID = "eventExtra";

    @BindView(R.id.iv_restaurant_image)
    ImageView detailImage;

    @BindView(R.id.restaurant_detail_tab_layout)
    TabLayout tabLayout;

    private ViewPager mPager;
    private PagerAdapter mAdapter;
    private int restaurantId;

    private RestaurantVO restaurantVO;

    public static Intent newIntent(Context context, int eventIdExtra) {
        Intent intent = new Intent(context, DetailsActivity.class);
        intent.putExtra(EXTRA_RESTAURANT_ID, eventIdExtra);
        return intent;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TabLayout topTabLayout = findViewById(R.id.restaurant_detail_tab_layout);
        mPager = findViewById(R.id.vp_restaurant_detail);

        mAdapter = new RestaurantFragmentPagerAdpater(getSupportFragmentManager());
        mPager.setAdapter(mAdapter);

        topTabLayout.setupWithViewPager(mPager);

        restaurantId = getIntent().getIntExtra(EXTRA_RESTAURANT_ID, 0);
    }




    @Override
    public void onTapRestaurant(int restaurantId) {

    }

    @Override
    public void onFabClicked(RestaurantVO restaurant) {
        String location = Uri.encode( String.valueOf(restaurant.getRestaurantLocation().getLattitude()) + "," +
                String.valueOf(restaurant.getRestaurantLocation().getLongitude()));

        Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                Uri.parse("https://www.google.com/maps/dir/?api=1&destination=" + location +"&travelmode=driving"));
        startActivity(intent);
    }

    @Override
    public void showErrorSnack(String errMessage) {

    }
}
