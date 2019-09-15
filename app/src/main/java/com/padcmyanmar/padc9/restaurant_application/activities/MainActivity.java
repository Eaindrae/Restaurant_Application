package com.padcmyanmar.padc9.restaurant_application.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.padcmyanmar.padc9.restaurant_application.Delegate.RestaurantDelegate;
import com.padcmyanmar.padc9.restaurant_application.R;
import com.padcmyanmar.padc9.restaurant_application.data.model.RestaurantModel;
import com.padcmyanmar.padc9.restaurant_application.data.vos.RestaurantVO;
import com.padcmyanmar.padc9.restaurant_application.fragments.RestaurantDetailFragment;

import androidx.annotation.NonNull;

import android.view.MenuItem;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements RestaurantDelegate {

    public static final String EXTRA_HOTEL_ID = "eventExtra";



//
//@BindView(R.id.fab)
//FloatingActionButton fabNav;
public static RestaurantModel restaurantModel;
    @BindView(R.id.bottomNavigationView)
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        loadExploreFragment();
        restaurantModel = mRestaurantModel;

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.action_camera : return true;
                    case R.id.action_explore :loadExploreFragment(); return true;
                    case R.id.action_pages : return true;
                    case R.id.action_noti : return true;
                    case R.id.action_profile: return true;
                }
                return false;
            }
        });


    }
    private void loadExploreFragment() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_frame_layout, new RestaurantDetailFragment())
                .addToBackStack(null)
                .commit();
    }


    @Override
    public void onTapRestaurant(int restaurantId) {
        Intent intent = DetailsActivity.newIntent(getApplicationContext(), restaurantId);
        startActivity(intent);
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
        showErrorSnack(errMessage);
    }


}



