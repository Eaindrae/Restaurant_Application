package com.padcmyanmar.padc9.restaurant_application.data.vos;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "menu",
        foreignKeys ={@ForeignKey(entity = RestaurantVO.class, parentColumns = "restaurant_id_pk",
                childColumns = "restaurant_id")},
        indices = {@Index(value = "id", unique = true)})
public class MenuVO {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "menu_id_pk")
    private int menuIdPk;

    @ColumnInfo(name = "id")
    @SerializedName("id")
    private int id;

    @ColumnInfo(name = "restaurant_id")
    private int restaurantId;

    @ColumnInfo(name = "name")
    @SerializedName("name")
    private String name;

    @ColumnInfo(name = "price")
    @SerializedName("price")
    private int price;

    public int getMenuIdPk() {
        return menuIdPk;
    }

    public void setMenuIdPk(int menuIdPk) {
        this.menuIdPk = menuIdPk;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }
}
