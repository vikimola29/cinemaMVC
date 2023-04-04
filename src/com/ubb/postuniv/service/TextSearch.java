package com.ubb.postuniv.service;

import com.ubb.postuniv.domain.ClientCard;
import com.ubb.postuniv.domain.Entity;
import com.ubb.postuniv.domain.Film;
import com.ubb.postuniv.repository.IRepository;

import java.util.ArrayList;
import java.util.List;

public class TextSearch {
    IRepository<Film> filmRepository;
    IRepository<ClientCard> clientCardRepository;

    public TextSearch(IRepository<Film> filmRepository, IRepository<ClientCard> clientCardRepository) {
        this.filmRepository = filmRepository;
        this.clientCardRepository = clientCardRepository;
    }

    public List<Entity> searchInText(String subString) {
        List<Film> filmList = filmRepository.readAll();
        List<Entity> resList= new ArrayList<>();
        for (Film f : filmList) {
            int doesExistFilm = f.getTitle().indexOf(subString);
            if (doesExistFilm != -1) {
                resList.add(f) ;
            }
        }

        List<ClientCard> clientList = clientCardRepository.readAll();
        for (ClientCard c : clientList) {
            int doesExistFirstName = c.getFirstName().indexOf(subString);
            int doesExistLastName = c.getLastName().indexOf(subString);
            if (doesExistFirstName != -1 || doesExistLastName != -1) {
                resList.add(c);
            }
        }

        return resList;
    }

}
