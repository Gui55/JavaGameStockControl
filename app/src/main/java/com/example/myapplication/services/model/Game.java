package com.example.myapplication.services.model;

public class Game {

    int id;
    String name;
    String image;
    int stock;

    public Game(int id, String name, String image, int stock) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
