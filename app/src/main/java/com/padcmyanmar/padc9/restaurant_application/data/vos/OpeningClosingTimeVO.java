package com.padcmyanmar.padc9.restaurant_application.data.vos;

import androidx.annotation.ColorInt;
import androidx.room.ColumnInfo;

import com.google.gson.annotations.SerializedName;

public class OpeningClosingTimeVO {

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
}
