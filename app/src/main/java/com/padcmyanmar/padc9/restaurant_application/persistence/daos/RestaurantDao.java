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
    public abstract long[] save(List<RestaurantVO> restaurants);

    @Query("SELECT restaurants.*, menus.* FROM restaurants INNER JOIN menus ON menus.restaurant_id = restaurants.id")
    public abstract List<RestaurantsAndMenusVO> all();

    public void save(List<RestaurantVO> restaurants, MenuDao menuDao) {

        List<MenuVO> menus = new ArrayList<>();

        for (RestaurantVO restaurant: restaurants ) {
            for(MenuVO menu : restaurant.getMenus()) {
                menu.setRestaurantId(restaurant.getId());
            }
            menus.addAll(restaurant.getMenus());
        }

        save(restaurants);
        menuDao.save(menus);
    }

    @Query("SELECT * FROM restaurants WHERE restaurant_id_pk = :id")
    public abstract RestaurantVO searchById(int id);

    @Query("SELECT * FROM restaurants ")
    public abstract List<RestaurantVO> searchByName();

}
