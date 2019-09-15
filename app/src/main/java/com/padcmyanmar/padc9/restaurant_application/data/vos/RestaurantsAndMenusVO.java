package com.padcmyanmar.padc9.restaurant_application.data.vos;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class RestaurantsAndMenusVO {
    @Embedded
    private RestaurantVO restaurant;

    @Relation(parentColumn = "id", entityColumn = "restaurant_id")
    private List<MenuVO> menus;

    public RestaurantVO getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(RestaurantVO restaurant) {
        this.restaurant = restaurant;
    }

    public List<MenuVO> getMenus() {
        return menus;
    }

    public void setMenus(List<MenuVO> menus) {
        this.menus = menus;
    }

}
