package com.padcmyanmar.padc9.restaurant_application.Delegate;

import android.view.View;


import com.padcmyanmar.padc9.restaurant_application.data.vos.RestaurantVO;
import com.padcmyanmar.padc9.restaurant_application.fragments.RestaurantDetailFragment;

public interface RestaurantDelegate {
    void  onTapRestaurant(int restaurantId);
    void onFabClicked(RestaurantVO restaurant);
    void showErrorSnack(String errMessage);
}
