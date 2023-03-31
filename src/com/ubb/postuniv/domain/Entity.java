package com.ubb.postuniv.domain;
//Prima iterație (săptămâna 3):
// toate funcționalitățile CRUD,
// interfață de consolă, excepții.
public class Entity {
    private int id;

    public Entity(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "id=" + id +
                '}';
    }
}
