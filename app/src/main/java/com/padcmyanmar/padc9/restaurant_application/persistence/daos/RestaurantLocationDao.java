package com.padcmyanmar.padc9.restaurant_application.persistence.daos;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.padcmyanmar.padc9.restaurant_application.data.vos.RestaurantLocationVO;
import com.padcmyanmar.padc9.restaurant_application.data.vos.RestaurantVO;

import java.util.List;

@Dao
public abstract class RestaurantLocationDao {

    @Insert
    public abstract void insertRestaurantLocation(List<RestaurantLocationVO> restaurantLocations);

    @Query("SELECT * FROM location WHERE restaurant_id=:id")
    public abstract List<RestaurantVO> getRestaurantLocById(int id);
}
