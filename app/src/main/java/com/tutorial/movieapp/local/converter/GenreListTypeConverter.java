package com.tutorial.movieapp.local.converter;


import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tutorial.movieapp.remote.model.Genre;

import java.lang.reflect.Type;
import java.util.List;

public class GenreListTypeConverter
{

    @TypeConverter
    public List<Genre> fromString(String value)
    {
        Type listType = new TypeToken<List<Genre>>()
        {
        }.getType();
        List<Genre> genres = new Gson().fromJson(value, listType);
        return genres;
    }

    @TypeConverter
    public String fromList(List<Genre> genres)
    {
        return new Gson().toJson(genres);
    }
}
