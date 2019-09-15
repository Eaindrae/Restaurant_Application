package com.padcmyanmar.padc9.restaurant_application.data.vos;

import androidx.room.ColumnInfo;

import com.google.gson.annotations.SerializedName;

public class RestaurantLocationVO {

    @SerializedName("latitude")
    @ColumnInfo(name ="latitude")
    private double lattitude;

    @SerializedName("longitude")
    @ColumnInfo(name = "longitude")
    private double longitude;

    public double getLattitude() {
        return lattitude;
    }

    public void setLattitude(double lattitude) {
        this.lattitude = lattitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
