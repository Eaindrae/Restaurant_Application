package com.padcmyanmar.padc9.restaurant_application.persistence.typeconverters;

import androidx.room.TypeConverter;

import com.google.gson.Gson;

import com.padcmyanmar.padc9.restaurant_application.data.vos.OpeningClosingTimeVO;

public class OpeningClosingTimeTypeConverter {
    @TypeConverter
    public static String OpeningClosingTimeToJson(OpeningClosingTimeVO openingClosingTimeVO){
       return new Gson().toJson(openingClosingTimeVO);
    }
    @TypeConverter
    public static OpeningClosingTimeVO eventOrganizerVO(String openingClosingTimeJson){
        return new Gson().fromJson(openingClosingTimeJson,OpeningClosingTimeVO.class);
    }
}
