package com.padcmyanmar.padc9.restaurant_application.data.vos;

import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.util.List;

@Entity(tableName = "restaurant",
        indices = {@Index(value = "id", unique = true)})
public class RestaurantVO {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "restaurant_id_pk")
    private int restaurantIdPk;

    @ColumnInfo(name = "id")
    @SerializedName("id")
    private int id;

    @ColumnInfo(name = "name")
    @SerializedName("name")
    private String name;

    @ColumnInfo(name = "image_url")
    @SerializedName("image_url")
    private String imageUrl;

    @ColumnInfo(name = "address")
    @SerializedName("address")
    private String address;

    @ColumnInfo(name = "description")
    @SerializedName("description")
    private String description;

    @SerializedName("opening_closing_times")
    @Ignore
    private OpeningClosingTimeVO openingClosingTime;

    @ColumnInfo(name = "rating")
    @SerializedName("rating")
    private String rating;

    @SerializedName("restaurant_location")
   @Ignore
    private RestaurantLocationVO restaurantLocation;

    @SerializedName("menus")
    @Ignore
    private List<MenuVO> menus;

    public int getRestaurantIdPk() {
        return restaurantIdPk;
    }

    public void setRestaurantIdPk(int restaurantIdPk) {
        this.restaurantIdPk = restaurantIdPk;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public OpeningClosingTimeVO getOpeningClosingTime() {
        return openingClosingTime;
    }

    public void setOpeningClosingTime(OpeningClosingTimeVO openingClosingTime) {
        this.openingClosingTime = openingClosingTime;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public RestaurantLocationVO getRestaurantLocation() {
        return restaurantLocation;
    }

    public void setRestaurantLocation(RestaurantLocationVO restaurantLocation) {
        this.restaurantLocation = restaurantLocation;
    }

    public List<MenuVO> getMenus() {
        return menus;
    }

    public void setMenus(List<MenuVO> menus) {
        this.menus = menus;
    }
}
