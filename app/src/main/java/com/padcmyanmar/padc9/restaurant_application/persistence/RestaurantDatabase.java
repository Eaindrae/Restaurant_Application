package com.padcmyanmar.padc9.restaurant_application.persistence;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;


import com.padcmyanmar.padc9.restaurant_application.data.vos.MenuVO;
import com.padcmyanmar.padc9.restaurant_application.data.vos.RestaurantVO;
import com.padcmyanmar.padc9.restaurant_application.persistence.daos.MenuDao;
import com.padcmyanmar.padc9.restaurant_application.persistence.daos.RestaurantDao;
import com.padcmyanmar.padc9.restaurant_application.utils.RestaurantConstant;

@Database(entities = {RestaurantVO.class, MenuVO.class}, version = 7,exportSchema = false)
public abstract class RestaurantDatabase extends RoomDatabase {

    private static RestaurantDatabase objInstance;

    public static RestaurantDatabase getInstance(Context context){
        if (objInstance == null) {
            objInstance = Room.databaseBuilder(context, RestaurantDatabase.class, RestaurantConstant.RESTAURANT_DB)
                    .allowMainThreadQueries() // Allow Synchronous call
                    .fallbackToDestructiveMigration() // Delete Current Database and add new Database.
                    .build();
        }
        return objInstance;
    }

    public abstract RestaurantDao restaurantDao();

    public abstract MenuDao menuDao();

    public boolean areRestaurantExisting() {
        return !restaurantDao().getAllRestaurants().isEmpty();
    }
}
