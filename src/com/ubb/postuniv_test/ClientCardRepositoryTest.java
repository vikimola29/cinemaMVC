package com.ubb.postuniv_test;

import com.ubb.postuniv.domain.ClientCard;
import com.ubb.postuniv.domain.Film;
import com.ubb.postuniv.repository.IUpsertRepository;
import com.ubb.postuniv.repository.InMemoryUpsertRepository;
import org.junit.jupiter.api.Assertions;

import java.util.List;

public class ClientCardRepositoryTest {
    @org.junit.jupiter.api.Test
    void validAdds_should_saveToRepositoryClientCard() throws Exception {
        // AAA - Arrange, Act, Assert

        // Arrange + Act
        IUpsertRepository<ClientCard> clientCardRepository = new InMemoryUpsertRepository<>();

        clientCardRepository.upsert(new ClientCard(1, "Cecil", "Baldwin", 313243, "14.03.1990", "1920.03.14 16:30", 30));
        clientCardRepository.upsert(new ClientCard(2, "Cecil", "Baldwin", 313243, "14.03.1990", "1920.03.14 16:30", 30));
        clientCardRepository.upsert(new ClientCard(3, "Carlos", "Scientist", 314343, "14.03.1990", "1920.03.14 16:30", 30));

        // Assert
        List<ClientCard> allClientCard = clientCardRepository.readAll();
        Assertions.assertEquals(3, allClientCard.size());
        Assertions.assertNotNull(clientCardRepository.read(1));
    }

    @org.junit.jupiter.api.Test
    void addsWithDuplicateId_should_raiseExceptionInRepositoryClientCard() throws Exception {
        IUpsertRepository<ClientCard> clientCardRepository = new InMemoryUpsertRepository<>();

        clientCardRepository.upsert(new ClientCard(1, "Cecil", "Baldwin", 313243, "14.03.1990", "1920.03.14 16:30", 30));
        clientCardRepository.upsert(new ClientCard(2, "Carlos", "Scientist", 314343, "14.03.1990", "1920.03.14 16:30", 30));
        ClientCard c3 = new ClientCard(1, "Cecil", "Baldwin", 313243, "14.03.1990", "1920.03.14 16:30", 30);
        Assertions.assertThrows(Exception.class, ()-> clientCardRepository.upsert(c3));
    }
}
