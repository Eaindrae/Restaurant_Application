package com.padcmyanmar.padc9.restaurant_application.data.model;

import android.content.Context;


import com.padcmyanmar.padc9.restaurant_application.data.vos.MenuVO;
import com.padcmyanmar.padc9.restaurant_application.data.vos.RestaurantVO;
import com.padcmyanmar.padc9.restaurant_application.data.vos.RestaurantsAndMenusVO;
import com.padcmyanmar.padc9.restaurant_application.network.dataAgents.RestaurantDataAgent;
import com.padcmyanmar.padc9.restaurant_application.network.responses.GetRestaurantResponse;
import com.padcmyanmar.padc9.restaurant_application.utils.RestaurantConstant;

import java.util.ArrayList;
import java.util.List;

public class RestaurantModelImpl extends BaseModel implements RestaurantModel {

    private static RestaurantModelImpl objInstance;

    public RestaurantModelImpl(Context context) {
        super(context);
    }

    public static void initialize(Context context) {
        objInstance = new RestaurantModelImpl(context);
    }

    public static RestaurantModelImpl getObjInstance() {
        if (objInstance == null)
            throw new RuntimeException(RestaurantConstant.MODEL_INITIALIZATION_EXCEPTION);

        return objInstance;
    }

    @Override
    public void getRestaurants(final RestaurantModelDelegates delegates) {

        if (mdatabase.areRestaurantExisting()) {
            List<RestaurantVO> restaurantList = mdatabase.restaurantDao().getAllRestaurants();
            delegates.onSuccess(restaurantList);

        } else {
            //get data from Network Layer.
            restaurantDataAgent.getRestaurants(new RestaurantDataAgent.GetRestaurantDataAgentDelegate() {
                @Override
                public void onSuccess(List<RestaurantVO> restaurants) {
                    mdatabase.restaurantDao().insertRestaurantAndMenus(restaurants, mdatabase.menuDao());
                    delegates.onSuccess(restaurants);
                }

                @Override
                public void onFailure(String message) {
                    delegates.onFailure(message);
                }
            }, RestaurantConstant.DUMMY_ACCESS_TOKEN);
        }
    }



    public RestaurantVO getRestaurantById(int id){
        return mdatabase.restaurantDao().getRestaurantById(id);
    }

    public List<MenuVO> getAllMenuByRestaurantId(int id){
        return mdatabase.menuDao().getMenusById(id);
    }

    public List<RestaurantVO> getRestaurantByName(String name){
        List<RestaurantVO> restaurants = mdatabase.restaurantDao().getAllRestaurants();
        List<RestaurantVO> resultRestrauants = new ArrayList<>();
        for (RestaurantVO restaurant : restaurants) {
            if(restaurant.getName().contains(name)){
                resultRestrauants.add(restaurant);
            }
        }
        return resultRestrauants;
    }
}
