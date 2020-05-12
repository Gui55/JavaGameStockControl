package com.example.myapplication.services.webservices;

import com.example.myapplication.services.model.Game;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface Requisition {

    @GET("games")
    Call<ArrayList<Game>> getGames();

    @FormUrlEncoded
    @PUT("games/{id}")
    Call<Game> updateGameStock(@Path("id") int id,
                               @Field("stock") int stock);

}
