package com.example.myapplication.services.repository;

import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;

import com.example.myapplication.dagger.DaggerRepoComponent;
import com.example.myapplication.services.model.Game;
import com.example.myapplication.services.webservices.Requisition;

import java.util.ArrayList;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GamesRepository {

    public static GamesRepository INSTANCE;

    @Inject
    public Requisition requisition;

    public MutableLiveData<ArrayList<Game>> getTheGames(){

        DaggerRepoComponent.create().inject(this);

        MutableLiveData<ArrayList<Game>> tGames = new MutableLiveData<>();

        requisition.getGames().enqueue(new Callback<ArrayList<Game>>() {
            @Override
            public void onResponse(Call<ArrayList<Game>> call, Response<ArrayList<Game>> response) {
                tGames.setValue(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<Game>> call, Throwable t) {

            }
        });

        return tGames;
    }

    public void updateThisGameStock(Game game){
        requisition.updateGameStock(game.getId(), game.getStock()).enqueue(new Callback<Game>() {
            @Override
            public void onResponse(Call<Game> call, Response<Game> response) {

            }

            @Override
            public void onFailure(Call<Game> call, Throwable t) {

            }
        });
    }

    public static GamesRepository getInstance(){
        if(INSTANCE==null){
             INSTANCE = new GamesRepository();
        }

        return INSTANCE;
    }

}
