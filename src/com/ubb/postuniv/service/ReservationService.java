package com.ubb.postuniv.service;

import com.ubb.postuniv.domain.*;
import com.ubb.postuniv.repository.IRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReservationService {
    private IRepository<Reservation> reservationRepository;
    private IRepository<Film> filmRepository;
    private IRepository<ClientCard> clientCardRepository;
    private ReservationValidator reservationValidator;

    public ReservationService(IRepository<Reservation> reservationRepository, IRepository<Film> filmRepository, IRepository<ClientCard> clientCardRepository, ReservationValidator reservationValidator) {
        this.reservationRepository = reservationRepository;
        this.filmRepository = filmRepository;
        this.clientCardRepository = clientCardRepository;
        this.reservationValidator = reservationValidator;
    }

    public void add(int id, int idFilm, int idClientCard, String dateTime) throws Exception {

        Reservation reservation = new Reservation(id, idFilm, idClientCard, dateTime);
        this.reservationValidator.validate(reservation,filmRepository);
        int gainedPoints = (int) Math.floor(filmRepository.read(idFilm).getPrice() * 0.1);

        ClientCard card = clientCardRepository.read(idClientCard);
        int newPoints = card.getPoints() + gainedPoints;
        card.setPoints(newPoints);
        this.clientCardRepository.update(card);

        Reservation reservation2 = new Reservation(id, idFilm, idClientCard, dateTime);
        this.reservationRepository.create(reservation2);
    }

    public List<Reservation> getAll() {
        return this.reservationRepository.readAll();
    }

    public Reservation getOne(int id) {
        return this.reservationRepository.read(id);
    }

    public void refresh(int id, int idFilm, int idClientCard, String dateTime) throws Exception {
        Reservation reservation = new Reservation(id, idFilm, idClientCard, dateTime);
        this.reservationValidator.validate(reservation,filmRepository);
        this.reservationRepository.update(reservation);
    }

    public void rid(int id) throws Exception {
        this.reservationRepository.delete(id);
    }

    public List<FilmProfitabilityDTO> getFilmProfitability() {
        Map<String, Integer> profitability = new HashMap<>();
        List<Reservation> reservationList = reservationRepository.readAll();

        for (Reservation reservation : reservationList) {
            int filmId = reservation.getIdFilm();
            String filmTitle = filmRepository.read(filmId).getTitle();
            if (!profitability.containsKey(filmTitle)) {
                profitability.put(filmTitle, 0);
            }
            int prevVal = profitability.get(filmTitle);
            profitability.put(filmTitle, prevVal + 1);
        }

        List<FilmProfitabilityDTO> res = new ArrayList<>();
        for (String filmTitle : profitability.keySet()){
            res.add(new FilmProfitabilityDTO(filmTitle, profitability.get(filmTitle)));
        }

        for (int i = 0; i < res.size(); i++) {
            for (int j = i + 1; j < res.size(); j++) {
                if (res.get(i).filmProfitability > res.get(j).filmProfitability) {
                    FilmProfitabilityDTO r = res.get(j);
                    res.set(j, res.get(i));
                    res.set(i, r);


                }
            }
        }
        return res;

    }

}
