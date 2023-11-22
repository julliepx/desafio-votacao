package com.sicredi.cooperativismo.validation;

import com.sicredi.cooperativismo.domain.Topic;
import com.sicredi.cooperativismo.exceptions.BadRequestException;

public class TopicValidationService {

    public static void validateTopicIsOpen(Topic topic) {

        throw new BadRequestException("A sessão de votação já foi encerrada.");
    }
}
