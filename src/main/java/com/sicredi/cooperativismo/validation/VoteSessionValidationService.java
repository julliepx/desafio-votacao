package com.sicredi.cooperativismo.validation;

import com.sicredi.cooperativismo.domain.VoteSession;
import com.sicredi.cooperativismo.exceptions.BadRequestException;

import java.time.LocalDateTime;

public class VoteSessionValidationService {

    public static void validateVoteSessionStatus(VoteSession voteSession) {
        if (voteSession.getEndTime().isBefore(LocalDateTime.now()))
            throw new BadRequestException("A sessão de votação já foi encerrada.");
    }
}
