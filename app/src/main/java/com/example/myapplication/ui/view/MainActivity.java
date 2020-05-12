package com.example.myapplication.ui.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.myapplication.ui.adapter.GameAdapter;
import com.example.myapplication.R;
import com.example.myapplication.services.model.Game;
import com.example.myapplication.services.webservices.Requisition;
import com.example.myapplication.viewmodel.MAViewModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RecyclerView recyclerView = findViewById(R.id.recycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        MAViewModel viewModel = ViewModelProviders.of(this).get(MAViewModel.class);



        viewModel.getGames().observe(this, new Observer<ArrayList<Game>>() {
            @Override
            public void onChanged(ArrayList<Game> games) {
                recyclerView.setAdapter(new GameAdapter(games, new GameAdapter.ButtonClickListener() {
                    @Override
                    public void onButtonClick(Game game) {
                        viewModel.minus(MainActivity.this, game);
                    }
                }, new GameAdapter.ButtonClickListener() {
                    @Override
                    public void onButtonClick(Game game) {
                        viewModel.plus(MainActivity.this, game);
                    }
                }));
            }
        });

        viewModel.getAreChanges().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if(recyclerView.getAdapter()!=null && aBoolean==true){
                    recyclerView.getAdapter().notifyDataSetChanged();
                    viewModel.setAreChanges(false);
                }
            }
        });
    }
}
