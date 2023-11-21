package com.sicredi.cooperativismo.validation;

import com.sicredi.cooperativismo.domain.Topic;
import com.sicredi.cooperativismo.domain.VoteSession;
import com.sicredi.cooperativismo.exceptions.BadRequestException;

import java.time.LocalDateTime;

public class TopicValidationService {

    public static void validateTopicIsOpen(Topic topic) {

        throw new BadRequestException("A sessão de votação já foi encerrada.");
    }
}
