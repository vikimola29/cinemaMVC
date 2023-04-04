package com.ubb.postuniv.domain;

import com.ubb.postuniv.repository.IUpsertRepository;

import java.util.List;
import java.util.regex.Pattern;

public class ClientCardValidator {


    public void validate(ClientCard clientCard, IUpsertRepository<ClientCard> clientCardRepository) throws Exception {
        List<ClientCard> clientCardList = clientCardRepository.readAll();
        for (ClientCard client : clientCardList) {
            if (client.getCNP() == clientCard.getCNP()) {
                throw new Exception("CMP already in use.");
            }
        }

        Pattern datePattern = Pattern.compile("^\\d{2}\\.\\d{2}\\.\\d{4}$");

        if (!datePattern.matcher(clientCard.getDateBorn()).matches()) {
            throw new Exception("Wrong format for Date Born.");
        }
        if (!datePattern.matcher(clientCard.getDateJoined()).matches()) {
            throw new Exception("Wrong format for Date Joined.");
        }
    }
}
