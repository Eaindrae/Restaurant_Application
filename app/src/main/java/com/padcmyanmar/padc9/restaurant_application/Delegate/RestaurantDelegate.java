package com.padcmyanmar.padc9.restaurant_application.Delegate;

import android.content.Context;
import android.view.View;




public interface RestaurantDelegate {
    void  onTapRestaurant(int restaurantId);
    void onGetAllRestaurantData(Context context, View view);
    void onSearchItems(Context context, View view, String keyword);
}
