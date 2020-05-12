package com.example.myapplication.viewmodel;

import android.content.Context;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.services.model.Game;
import com.example.myapplication.services.repository.GamesRepository;

import java.util.ArrayList;

public class MAViewModel extends ViewModel {

    MutableLiveData<ArrayList<Game>> games;
    MutableLiveData<Boolean> areChanges = new MutableLiveData<>();

    public MAViewModel(){
        games = GamesRepository.getInstance().getTheGames();
        areChanges.setValue(false);
    }

    public MutableLiveData<ArrayList<Game>> getGames() {
        return games;
    }

    public void minus(Context con, Game game){
        game.setStock(game.getStock()-1);
        GamesRepository.getInstance().updateThisGameStock(game);
        areChanges.setValue(true);
    }

    public void plus(Context con, Game game){
        game.setStock(game.getStock()+1);
        GamesRepository.getInstance().updateThisGameStock(game);
        areChanges.setValue(true);
    }

    public MutableLiveData<Boolean> getAreChanges() {
        return areChanges;
    }

    public void setAreChanges(Boolean bool){
        areChanges.setValue(bool);
    }
}
