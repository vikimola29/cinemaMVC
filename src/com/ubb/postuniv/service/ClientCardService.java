package com.ubb.postuniv.service;

import com.ubb.postuniv.domain.ClientCard;
import com.ubb.postuniv.repository.IRepository;

import java.util.List;

public class ClientCardService {
    private IRepository<ClientCard> clientCardRepository;

    public ClientCardService(IRepository<ClientCard> clientCardRepository) {
        this.clientCardRepository = clientCardRepository;
    }

    public void add(int id, String firstName, String lastName, int CNP, String dateBorn, String dateJoined, int points) throws Exception{
        ClientCard card = new ClientCard(id, firstName, lastName, CNP, dateBorn, dateJoined, points);
        this.clientCardRepository.create(card);
    }

    public List<ClientCard> getAll(){
        return this.clientCardRepository.readAll();
    }

    public ClientCard getOne(int id){
        return this.clientCardRepository.read(id);
    }

    public void refresh(int id, String firstName, String lastName, int CNP, String dateBorn, String dateJoined, int points) throws Exception{
        ClientCard card = new ClientCard(id, firstName, lastName,CNP,  dateBorn, dateJoined, points);
        this.clientCardRepository.update(card);
    }

    public void refreshPoints(int id, int addedPoints) throws Exception{
        ClientCard card = clientCardRepository.read(id);
        int newPoints = card.getPoints()+addedPoints;
        card.setPoints(newPoints);
        this.clientCardRepository.update(card);
    }


    public void rid(int id) throws Exception{
        this.clientCardRepository.delete(id);
    }
}
