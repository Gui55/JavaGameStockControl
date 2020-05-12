package com.example.myapplication.dagger;

import com.example.myapplication.services.repository.GamesRepository;
import com.example.myapplication.ui.view.MainActivity;

import dagger.Component;

@Component(modules = {RetroModule.class})
public interface RepoComponent {

    void inject(GamesRepository gamesRepository);

}
