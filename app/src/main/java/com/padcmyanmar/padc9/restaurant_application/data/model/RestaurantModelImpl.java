package com.padcmyanmar.padc9.restaurant_application.data.model;

import android.content.Context;


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

        if (mdatabase.isEmptyRestaurant()) {
            restaurantDataAgent.getRestaurants(new RestaurantDataAgent.GetRestaurantDataAgentDelegate() {
                @Override
                public void onSuccess(List<RestaurantVO> restaurants) {
                    mdatabase.restaurantDao().save(restaurants, mdatabase.menuDao());

                    delegates.onSuccess(restaurants);
                }

                @Override
                public void onFailure(String errorMessage) {
                    delegates.onFailure(errorMessage);
                }
            });
        } else {
            List<RestaurantsAndMenusVO> restaurantsAndMenus = mdatabase.restaurantDao().all();
            List<RestaurantVO> restaurants = new ArrayList<>();

            for (RestaurantsAndMenusVO restaurantsAndMenu : restaurantsAndMenus) {



                restaurantsAndMenu.getRestaurant().setMenus(restaurantsAndMenu.getMenus());
                restaurants.add(restaurantsAndMenu.getRestaurant());
            }

            delegates.onSuccess(restaurants);
        }
    }


    @Override
    public RestaurantVO searchById(int id) {
        return mdatabase.restaurantDao().searchById(id);
    }

    @Override
    public List<RestaurantVO> filterHouse(String query) {
        List<RestaurantVO> restaurantVoList = mdatabase.restaurantDao().searchByName();
        List<RestaurantVO> resultList = new ArrayList<>();
        for (RestaurantVO restaurantVo :
                restaurantVoList) {
            if (restaurantVo.getName().toLowerCase().contains(query.toLowerCase()))
                resultList.add(restaurantVo);
        }
        return resultList;
    }
}
