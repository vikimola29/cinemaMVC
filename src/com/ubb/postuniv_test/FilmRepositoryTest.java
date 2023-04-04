package com.ubb.postuniv_test;

import com.ubb.postuniv.domain.Film;
import com.ubb.postuniv.repository.IRepository;
import com.ubb.postuniv.repository.IUpsertRepository;
import com.ubb.postuniv.repository.InMemoryRepository;
import com.ubb.postuniv.repository.InMemoryUpsertRepository;
import org.junit.jupiter.api.Assertions;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class FilmRepositoryTest {

    @org.junit.jupiter.api.Test
    void validAdds_should_saveToRepositoryFilm() throws Exception {
        // AAA - Arrange, Act, Assert

        // Arrange + Act
        IUpsertRepository<Film> filmRepository = new InMemoryUpsertRepository<>();

        filmRepository.upsert(new Film(1, "Cecil", 2020, 10, true));
        filmRepository.upsert(new Film(2, "Bob", 2021, 22.4, true));
        filmRepository.upsert(new Film(3, "Cecil", 2021, 22.4, true));

        // Assert
        List<Film> allFilms = filmRepository.readAll();
        Assertions.assertEquals(3, allFilms.size());
        Assertions.assertNotNull(filmRepository.read(1));
    }

    @org.junit.jupiter.api.Test
    void addsWithDuplicateId_should_raiseExceptionInRepositoryFilm() throws Exception {
        IUpsertRepository<Film> filmRepository = new InMemoryUpsertRepository<>();
        filmRepository.upsert(new Film(1, "Cecil", 2020, 10, true));
        filmRepository.upsert(new Film(2, "Bob", 2021, 22.4, true));
        Film f3 = new Film(1, "Cecil", 2021, 22.4, true);
        Assertions.assertThrows(Exception.class, ()-> filmRepository.upsert(f3));
    }



    }
