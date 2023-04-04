package com.ubb.postuniv.domain;

public class Film extends Entity{
    private String title;
    private int releaseYear;
    private double price;
    private boolean inProgram;

    public Film(int id, String title, int releaseYear, double price, boolean inProgram) {
        super(id);
        this.title = title;
        this.releaseYear = releaseYear;
        this.price = price;
        this.inProgram = inProgram;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean getInProgram() {
        return inProgram;
    }

    public void setInProgram(boolean inProgram) {
        this.inProgram = inProgram;
    }

    @Override
    public String toString() {
        return "Film{" +
                "id="+ this.getId()+ '\'' +
                "title='" + title + '\'' +
                ", releaseYear=" + releaseYear +
                ", price=" + price +
                ", inProgram='" + inProgram + '\'' +
                '}';
    }
}

