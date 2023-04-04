package com.ubb.postuniv.domain;

public class FilmProfitabilityDTO {
    //Afișarea filmelor ordonate descrescător după numărul de rezervări.
    public String filmTitle;
    public int filmProfitability;

    public FilmProfitabilityDTO(String filmTitle, int filmProfitability) {
        this.filmTitle = filmTitle;
        this.filmProfitability = filmProfitability;
    }

    @Override
    public String toString() {
        return "FilmProfitabilityDTO{" +
                "filmTitle=" + filmTitle +
                ", filmProfitability=" + filmProfitability +
                '}';
    }
}
