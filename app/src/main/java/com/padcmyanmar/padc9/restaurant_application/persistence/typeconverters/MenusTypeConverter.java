package com.padcmyanmar.padc9.restaurant_application.persistence.typeconverters;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import com.padcmyanmar.padc9.restaurant_application.data.vos.MenuVO;

import java.lang.reflect.Type;
import java.util.List;

public class MenusTypeConverter {
    @TypeConverter
    public static String interestedUserToJson(List<MenuVO> userVO){
        return new Gson().toJson(userVO);
    }
    @TypeConverter
    public static List<MenuVO> userVO(String interestedUserJson){
        Type userListType=new TypeToken<List<MenuVO>>(){}.getType();
        return new Gson().fromJson(interestedUserJson, userListType);
    }
}
