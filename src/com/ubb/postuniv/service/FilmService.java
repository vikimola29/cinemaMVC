package com.ubb.postuniv.service;

import com.ubb.postuniv.domain.Film;
import com.ubb.postuniv.domain.FilmValidator;
import com.ubb.postuniv.repository.IRepository;
import com.ubb.postuniv.repository.IUpsertRepository;

import java.util.List;

public class FilmService {
    private IUpsertRepository<Film> filmRepository;
    private FilmValidator filmValidator;


    public FilmService(IUpsertRepository<Film> filmRepository, FilmValidator filmValidator) {
        this.filmRepository = filmRepository;
        this.filmValidator = filmValidator;
    }

    public void add(int id, String title, int releaseYear, double price, boolean inProgram) throws Exception{
        Film film = new Film(id, title, releaseYear, price, inProgram);
        this.filmValidator.validate(film);
        this.filmRepository.upsert(film);
    }

    public List<Film> getAll(){
    return this.filmRepository.readAll();
    }

    public Film getOne(int id){
        return this.filmRepository.read(id);
    }

    public void refresh(int id, String title, int releaseYear, double price, boolean inProgram) throws Exception{
        Film film = new Film(id, title, releaseYear, price, inProgram);
        this.filmValidator.validate(film);
        this.filmRepository.upsert(film);
    }

    public void rid(int id) throws Exception{
        this.filmRepository.delete(id);
    }

}
