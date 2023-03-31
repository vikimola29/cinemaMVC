package com.ubb.postuniv.service;

import com.ubb.postuniv.domain.ClientCard;
import com.ubb.postuniv.domain.Film;
import com.ubb.postuniv.domain.Reservation;
import com.ubb.postuniv.repository.IRepository;

import java.util.List;

public class ReservationService {
    private IRepository<Reservation> reservationRepository;
    private IRepository<Film> filmRepository;
    private IRepository<ClientCard> clientCardRepository;

    public ReservationService(IRepository<Reservation> reservationRepository, IRepository<Film> filmRepository, IRepository<ClientCard> clientCardRepository) {
        this.reservationRepository = reservationRepository;
        this.filmRepository = filmRepository;
        this.clientCardRepository = clientCardRepository;
    }

    public void add(int id, int idFilm, int idClientCard, String dateTime) throws Exception {
        int gainedPoints = (int) Math.floor(filmRepository.read(idFilm).getPrice() * 0.1);
        System.out.println("gainedP: "+gainedPoints);
        ClientCard card = clientCardRepository.read(idClientCard);
//        System.out.println(card.toString());
        int newPoints = card.getPoints() + gainedPoints;
        card.setPoints(newPoints);
        this.clientCardRepository.update(card);

        Reservation reservation = new Reservation(id, idFilm, idClientCard, dateTime);
        this.reservationRepository.create(reservation);
    }

    public List<Reservation> getAll() {
        return this.reservationRepository.readAll();
    }

    public Reservation getOne(int id) {
        return this.reservationRepository.read(id);
    }

    public void refresh(int id, int idFilm, int idClientCard, String dateTime) throws Exception {
        Reservation reservation = new Reservation(id, idFilm, idClientCard, dateTime);
        this.reservationRepository.update(reservation);
    }

    public void rid(int id) throws Exception {
        this.reservationRepository.delete(id);
    }

}
