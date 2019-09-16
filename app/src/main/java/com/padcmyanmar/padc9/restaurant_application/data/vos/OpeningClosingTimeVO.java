package com.padcmyanmar.padc9.restaurant_application.data.vos;

import androidx.annotation.ColorInt;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "open_closing_time",
        indices = {@Index(value = "time_id_pk", unique = true)},
        foreignKeys = {@ForeignKey(entity = RestaurantVO.class, parentColumns = "id", childColumns = "restaurant_id")})
public class OpeningClosingTimeVO {


    @ColumnInfo(name = "time_id_pk")
    private int timeIdPK;

    @ColumnInfo(name = "restaurant_id")
    private int restaurantId;

    @SerializedName("opening_time")
    @ColumnInfo(name="opening_time")
    private String openingTime;


    @SerializedName("closing_time")
    @ColumnInfo(name="closing_time")
    private String closingTime;


    public String getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(String openingTime) {
        this.openingTime = openingTime;
    }

    public String getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(String closingTime) {
        this.closingTime = closingTime;
    }

    public int getTimeIdPK() {
        return timeIdPK;
    }

    public void setTimeIdPK(int timeIdPK) {
        this.timeIdPK = timeIdPK;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }
}
