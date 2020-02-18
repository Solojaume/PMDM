package com.example.proyectofinal.model;

public class Preferencias {
    private int id, userId, generoId;

    public Preferencias(int id, int userId, int generoId) {
        this.id = id;
        this.userId = userId;
        this.generoId = generoId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getGeneroId() {
        return generoId;
    }

    public void setGeneroId(int generoId) {
        this.generoId = generoId;
    }
}
