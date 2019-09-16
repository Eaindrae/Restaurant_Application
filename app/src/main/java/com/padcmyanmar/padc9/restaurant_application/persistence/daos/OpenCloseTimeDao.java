package com.padcmyanmar.padc9.restaurant_application.persistence.daos;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.padcmyanmar.padc9.restaurant_application.data.vos.OpeningClosingTimeVO;

@Dao
public abstract class OpenCloseTimeDao {

    @Insert
    public abstract void insertOpenCloseTime(OpeningClosingTimeVO openingClosingTime);

    @Query("SELECT * FROM open_closing_time WHERE restaurant_id=:id")
    public abstract OpeningClosingTimeVO findOpenCloseTimeById(int id);
}
