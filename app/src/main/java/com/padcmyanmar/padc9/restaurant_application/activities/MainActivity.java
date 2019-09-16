package com.padcmyanmar.padc9.restaurant_application.activities;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.padcmyanmar.padc9.restaurant_application.Delegate.RestaurantDelegate;
import com.padcmyanmar.padc9.restaurant_application.R;
import com.padcmyanmar.padc9.restaurant_application.adapters.RecyclerListAdapter;
import com.padcmyanmar.padc9.restaurant_application.data.model.RestaurantModel;
import com.padcmyanmar.padc9.restaurant_application.data.vos.RestaurantVO;
import com.padcmyanmar.padc9.restaurant_application.fragments.ExploreFragment;
import com.padcmyanmar.padc9.restaurant_application.fragments.RestaurantDetailFragment;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.MenuItem;
import android.view.View;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements RestaurantDelegate {

    @BindView(R.id.bottomNavigationView)
    BottomNavigationView bottomNavigationView;

    RecyclerView rvRestaurants;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setNavigationItemSelectedListener();
    }


    @Override
    public void onSearchItems(Context context, View view, String keyword) {
        rvRestaurants = view.findViewById(R.id.rv_restaurants);
        rvRestaurants.setLayoutManager(new LinearLayoutManager(context, RecyclerView.VERTICAL, false));
        final RecyclerListAdapter adapter = new RecyclerListAdapter(this);
        adapter.setNewData(mRestaurantModel.getRestaurantByName(keyword));
        rvRestaurants.setAdapter(adapter);
    }

    private void setNavigationItemSelectedListener() {

        //do first load.
        loadExploreFragment();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                int id = menuItem.getItemId();

                switch (id) {
                    case R.id.action_explore:
                        loadExploreFragment();
                        break;

                    case R.id.action_pages:
                        //cat
                        break;

                    case R.id.action_camera:
                        //camera
                        break;

                    case R.id.action_noti:
                        //noti
                        break;

                    case R.id.action_profile:
                        //person
                        break;
                }

                return true;
            }
        });
    }

    @Override
    public void onTapRestaurant(int restaurantId) {

    }

    @Override
    public void onGetAllRestaurantData(final Context context, final View view) {

        final RecyclerListAdapter adapter = new RecyclerListAdapter(this);
        rvRestaurants = view.findViewById(R.id.rv_restaurants);
        rvRestaurants.setLayoutManager(new LinearLayoutManager(context, RecyclerView.VERTICAL, false));

        mRestaurantModel.getRestaurants(new RestaurantModel.RestaurantModelDelegates() {
            @Override
            public void onSuccess(List<RestaurantVO> restaurants) {
                adapter.setNewData(restaurants);
                rvRestaurants.setAdapter(adapter);
            }

            @Override
            public void onFailure(String message) {
                showSnack(message);
            }
        });
    }

    private void loadExploreFragment() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_frame_layout, ExploreFragment.getObjInstance(this))
                .addToBackStack(null)
                .commit();
    }
}


