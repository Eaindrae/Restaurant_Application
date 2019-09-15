package com.padcmyanmar.padc9.restaurant_application.persistence.daos;



import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;


import com.padcmyanmar.padc9.restaurant_application.data.vos.MenuVO;

import java.util.List;

@Dao
public interface MenuDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long[] save(List<MenuVO> menus);

    @Query("SELECT * FROM menus")
    List<MenuVO> all();
}
