package com.padcmyanmar.padc9.restaurant_application.persistence.typeconverters;

import androidx.room.TypeConverter;

import com.google.gson.Gson;

import com.padcmyanmar.padc9.restaurant_application.data.vos.RestaurantLocationVO;

public class RestaurantLocationTypeConverter {
    @TypeConverter
    public static String restaurantLocationToJson(RestaurantLocationVO restaurantLocationVO){
        return new Gson().toJson(restaurantLocationVO);
    }
    @TypeConverter
    public static RestaurantLocationVO eventRequirementsVO(String restaurantLocationtJson){
        return new Gson().fromJson(restaurantLocationtJson,RestaurantLocationVO.class);
    }
}
