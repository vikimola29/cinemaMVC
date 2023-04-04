package com.ubb.postuniv.domain;

public class FilmValidator {


    public void validate(Film film) throws Exception{
        if (film.getTitle().length()==0){
            throw new Exception("Film has to have a title");
        }

//        if (film.getReleaseYear() < 1895 || film.getReleaseYear() > 2050){
//            throw new Exception("Wrong release date.");
//        }

        if (film.getPrice()<0){
            throw new Exception("Price can't be negative");
        }
    }
}
