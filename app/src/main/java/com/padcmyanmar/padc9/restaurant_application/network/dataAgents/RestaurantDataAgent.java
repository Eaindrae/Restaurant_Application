package com.padcmyanmar.padc9.restaurant_application.network.dataAgents;


import com.padcmyanmar.padc9.restaurant_application.data.vos.RestaurantVO;
import com.padcmyanmar.padc9.restaurant_application.network.responses.GetRestaurantResponse;

import java.util.List;

public interface RestaurantDataAgent {

    void getRestaurants(GetRestaurantDataAgentDelegate getRestaurantDataAgentDelegate,String accessToken);

    interface GetRestaurantDataAgentDelegate {
        void onSuccess(List<RestaurantVO> restaurantVoList);
        void onFailure(String errorMessage);
    }
}