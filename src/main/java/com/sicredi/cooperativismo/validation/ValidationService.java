package com.sicredi.cooperativismo.validation;

import com.sicredi.cooperativismo.domain.Affiliated;
import com.sicredi.cooperativismo.domain.VoteSession;
import com.sicredi.cooperativismo.exceptions.BadRequestException;

import java.time.LocalDateTime;

public class ValidationService {

    public static void validateVoteSessionStatus(VoteSession voteSession) {
        if (voteSession.getEndTime().isBefore(LocalDateTime.now()))
            throw new BadRequestException("A sessão de votação já foi encerrada.");
    }

    public static void validateAffiliatedVoteStatus(VoteSession voteSession, Affiliated affiliated) {
        if (voteSession.getVotes().stream().anyMatch(vote -> vote.getAffiliated().getId().equals(affiliated.getId()))) {
            throw new BadRequestException("O associado já votou nesta sessão.");
        }
    }
}
