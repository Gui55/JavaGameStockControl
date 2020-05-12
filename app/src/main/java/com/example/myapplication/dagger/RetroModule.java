package com.example.myapplication.dagger;

import com.example.myapplication.services.webservices.Requisition;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class RetroModule {

    @Provides
    public Requisition provideRequisition(){
        return new Retrofit.Builder().baseUrl("https://5e737258be8c5400165c393c.mockapi.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(Requisition.class);
    }

}
