package com.padcmyanmar.padc9.restaurant_application.data.model;


import com.padcmyanmar.padc9.restaurant_application.data.vos.RestaurantVO;

import java.util.List;

public interface RestaurantModel {

    void getRestaurants(RestaurantModelDelegates delegates);


    interface RestaurantModelDelegates {
        void onSuccess(List<RestaurantVO> restaurants);
        void onFailure(String errorMessage);
    }
}
