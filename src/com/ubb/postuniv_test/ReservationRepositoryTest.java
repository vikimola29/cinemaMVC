package com.ubb.postuniv_test;

import com.ubb.postuniv.domain.Reservation;
import com.ubb.postuniv.repository.IUpsertRepository;
import com.ubb.postuniv.repository.InMemoryUpsertRepository;
import org.junit.jupiter.api.Assertions;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ReservationRepositoryTest {

    @org.junit.jupiter.api.Test
    void validAdds_should_saveToRepositoryReservation() throws Exception {
        // AAA - Arrange, Act, Assert

        // Arrange + Act
        IUpsertRepository<Reservation> reservationRepository = new InMemoryUpsertRepository<>();

        reservationRepository.upsert(new Reservation(1, 1, 1,"14.03.1990 16:30"));
        reservationRepository.upsert(new Reservation(2, 2, 2,"14.03.1990 16:30"));
        reservationRepository.upsert(new Reservation(3, 1, 1,"14.03.1990 16:30"));

        // Assert
        List<Reservation> allFilms = reservationRepository.readAll();
        Assertions.assertEquals(3, allFilms.size());
        Assertions.assertNotNull(reservationRepository.read(1));
    }

    @org.junit.jupiter.api.Test
    void addsWithDuplicateId_should_raiseExceptionInRepositoryReservation() throws Exception {
        IUpsertRepository<Reservation> reservationRepository = new InMemoryUpsertRepository<>();
        reservationRepository.upsert(new Reservation(1, 1, 1,"14.03.1990 16:30"));
        reservationRepository.upsert(new Reservation(2, 2, 2,"14.03.1990 16:30"));
        Reservation r3 = new Reservation(1, 1, 1,"14.03.1990 16:30");
        Assertions.assertThrows(Exception.class, ()-> reservationRepository.upsert(r3));
    }

}

