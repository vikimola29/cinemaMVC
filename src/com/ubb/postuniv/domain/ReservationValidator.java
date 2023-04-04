package com.ubb.postuniv.domain;

import com.ubb.postuniv.repository.IRepository;

import java.util.regex.Pattern;

public class ReservationValidator {

    public void validate(Reservation reservation, IRepository<Film> filmRepository) throws ReservationValidationException {
        Pattern datePattern = Pattern.compile("^\\d{2}\\.\\d{2}\\.\\d{4} \\d{2}:\\d{2}$");

        if (filmRepository.read(reservation.getIdFilm()) == null || !filmRepository.read(reservation.getIdFilm()).getInProgram()) {
            throw new ReservationValidationException("Film w/ id of " + reservation.getIdFilm() + " doesn't exist OR film not in program anymore.");
        }
    }
}
