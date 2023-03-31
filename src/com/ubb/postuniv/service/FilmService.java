package com.ubb.postuniv.service;

import com.ubb.postuniv.domain.Film;
import com.ubb.postuniv.repository.IRepository;

import java.util.List;

public class FilmService {
    private IRepository<Film> filmRepository;


    public FilmService(IRepository<Film> filmRepository) {
        this.filmRepository = filmRepository;
    }

    public void add(int id, String title, int releaseYear, double price, String inProgram) throws Exception{
        Film film = new Film(id, title, releaseYear, price, inProgram);
        this.filmRepository.create(film);
    }

    public List<Film> getAll(){
    return this.filmRepository.readAll();
    }

    public Film getOne(int id){
        return this.filmRepository.read(id);
    }

    public void refresh(int id, String title, int releaseYear, double price, String inProgram) throws Exception{
        Film film = new Film(id, title, releaseYear, price, inProgram);
        this.filmRepository.update(film);
    }

    public void rid(int id) throws Exception{
        this.filmRepository.delete(id);
    }

}
