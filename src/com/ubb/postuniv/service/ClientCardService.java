package com.ubb.postuniv.service;

import com.ubb.postuniv.domain.ClientCard;
import com.ubb.postuniv.domain.ClientCardValidator;
import com.ubb.postuniv.repository.IRepository;
import com.ubb.postuniv.repository.IUpsertRepository;

import java.util.List;

public class ClientCardService {
    private IUpsertRepository<ClientCard> clientCardRepository;
    private ClientCardValidator clientCardValidator;

    public ClientCardService(IUpsertRepository<ClientCard> clientCardRepository, ClientCardValidator clientCardValidator) {
        this.clientCardRepository = clientCardRepository;
        this.clientCardValidator = clientCardValidator;
    }

    public void add(int id, String firstName, String lastName, int CNP, String dateBorn, String dateJoined, int points) throws Exception {
        ClientCard card = new ClientCard(id, firstName, lastName, CNP, dateBorn, dateJoined, points);
        this.clientCardValidator.validate(card, clientCardRepository);
        this.clientCardRepository.upsert(card);
    }

    public List<ClientCard> getAll() {
        return this.clientCardRepository.readAll();
    }

    public ClientCard getOne(int id) {
        return this.clientCardRepository.read(id);
    }

    public void refresh(int id, String firstName, String lastName, int CNP, String dateBorn, String dateJoined, int points) throws Exception {
        ClientCard card = new ClientCard(id, firstName, lastName, CNP, dateBorn, dateJoined, points);
        this.clientCardValidator.validate(card, clientCardRepository);
        this.clientCardRepository.upsert(card);
    }

    public void refreshPoints(int id, int addedPoints) throws Exception {
        ClientCard card = clientCardRepository.read(id);
        int newPoints = card.getPoints() + addedPoints;
        card.setPoints(newPoints);
        this.clientCardValidator.validate(card, clientCardRepository);
        this.clientCardRepository.upsert(card);
    }


    public void rid(int id) throws Exception {
        this.clientCardRepository.delete(id);
    }
}
