package com.example.assignment.rest_api;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface APIs {
    @GET
    Call<JsonObject> getMatches(@Url String code);

}
