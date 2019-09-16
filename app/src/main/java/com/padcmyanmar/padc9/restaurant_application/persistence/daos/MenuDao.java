package com.padcmyanmar.padc9.restaurant_application.persistence.daos;


import android.view.Menu;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.padcmyanmar.padc9.restaurant_application.data.vos.MenuVO;

import java.util.List;

@Dao
public abstract class MenuDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract void insertMenus(List<MenuVO> menuList);

    @Query("SELECT * FROM menu WHERE restaurant_id=:id")
    public abstract List<MenuVO> getMenusById(int id);

    @Query("SELECT * FROM menu")
    public abstract List<MenuVO> getAllMenus();
}