package com.sicredi.cooperativismo.stubs;

import com.sicredi.cooperativismo.domain.Topic;
import com.sicredi.cooperativismo.domain.VoteSession;
import com.sicredi.cooperativismo.dto.request.VoteSessionRequest;
import com.sicredi.cooperativismo.mapper.IVoteSessionMapper;

import java.time.LocalDateTime;
import java.util.ArrayList;

public interface VoteSessionStub {

    static VoteSession buildVoteSession() {
        return VoteSession.builder()
                .id(1L)
                .startTime(LocalDateTime.now())
                .endTime(LocalDateTime.now().plusMinutes(2))
                .topic(new Topic(1L, "Topic One"))
                .votes(new ArrayList<>())
                .build();
    }

    static VoteSessionRequest buildVoteSessionRequest() {
        return VoteSessionRequest.builder()
                .topicId(1L)
                .endTime(LocalDateTime.now().plusMinutes(2))
                .build();
    }
}
