package com.padcmyanmar.padc9.restaurant_application.data.model;


import android.content.Context;


import com.padcmyanmar.padc9.restaurant_application.network.dataAgents.RestaurantDataAgent;
import com.padcmyanmar.padc9.restaurant_application.network.dataAgents.RetrofitRestaurantDataAgent;
import com.padcmyanmar.padc9.restaurant_application.persistence.RestaurantDatabase;

public abstract class BaseModel {

    protected RetrofitRestaurantDataAgent restaurantDataAgent;
    protected RestaurantDatabase mdatabase;

    public BaseModel(Context context) {
        restaurantDataAgent = RetrofitRestaurantDataAgent.getObjInstance();
        mdatabase = RestaurantDatabase.getInstance(context);
    }


}
