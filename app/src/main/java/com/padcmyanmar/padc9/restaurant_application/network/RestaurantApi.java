package com.padcmyanmar.padc9.restaurant_application.network;

import com.padcmyanmar.padc9.restaurant_application.network.responses.GetRestaurantResponse;
import com.padcmyanmar.padc9.restaurant_application.utils.RestaurantConstant;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RestaurantApi {

    @GET(RestaurantConstant.GET_ALL_RESTAURANTS)
    Call<GetRestaurantResponse> getAllRestaurants(@Query(RestaurantConstant.PARAM_ACCESS_TOKEN) String accessToken);
}
