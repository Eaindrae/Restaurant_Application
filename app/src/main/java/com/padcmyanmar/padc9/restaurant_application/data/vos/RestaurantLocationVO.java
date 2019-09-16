package com.padcmyanmar.padc9.restaurant_application.data.vos;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;

import com.google.gson.annotations.SerializedName;
@Entity(tableName = "location",
        indices = {@Index(value = "location_id_pk")},
        foreignKeys = {@ForeignKey(entity = RestaurantVO.class, parentColumns = "id", childColumns = "restaurant_id")})
public class RestaurantLocationVO {



    @ColumnInfo(name = "location_id_pk")
    private int locationIdPk;

    @ColumnInfo(name = "restaurant_id")
    private int restaurantId;

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

    public int getLocationIdPk() {
        return locationIdPk;
    }

    public void setLocationIdPk(int locationIdPk) {
        this.locationIdPk = locationIdPk;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }
}
