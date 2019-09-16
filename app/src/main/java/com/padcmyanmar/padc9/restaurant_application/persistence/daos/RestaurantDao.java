package com.padcmyanmar.padc9.restaurant_application.persistence.daos;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;


import com.padcmyanmar.padc9.restaurant_application.data.vos.MenuVO;
import com.padcmyanmar.padc9.restaurant_application.data.vos.RestaurantVO;
import com.padcmyanmar.padc9.restaurant_application.data.vos.RestaurantsAndMenusVO;

import java.util.ArrayList;
import java.util.List;

@Dao
public abstract class RestaurantDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract void insertRestaurant(List<RestaurantVO> restaurants);

    @Query("SELECT * from restaurant")
    public abstract List<RestaurantVO> getAllRestaurants();

    @Query("SELECT * from restaurant WHERE id=:id")
    public abstract RestaurantVO getRestaurantById(int id);

    @Insert
    public void insertRestaurantAndMenus(List<RestaurantVO> restaurants, MenuDao menuDao){

        List<MenuVO> menuList = new ArrayList<>();

        for (RestaurantVO restaurant : restaurants) {
            for(MenuVO menu :restaurant.getMenus()){
                menu.setRestaurantId(restaurant.getId());
            }
            menuList.addAll(restaurant.getMenus());
        }

        insertRestaurant(restaurants);
        menuDao.insertMenus(menuList);
    }
}
