package com.padcmyanmar.padc9.restaurant_application;

import android.app.Application;

import com.padcmyanmar.padc9.restaurant_application.data.model.RestaurantModelImpl;

public class RestaurantApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        RestaurantModelImpl.initialize(getApplicationContext());
    }
}
