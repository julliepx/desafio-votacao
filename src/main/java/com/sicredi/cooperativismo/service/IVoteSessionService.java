package com.sicredi.cooperativismo.service;

import com.sicredi.cooperativismo.domain.VoteSession;
import com.sicredi.cooperativismo.dto.request.TopicRequest;
import com.sicredi.cooperativismo.dto.request.VoteSessionRequest;

public interface IVoteSessionService {

    VoteSession createVoteSession(VoteSessionRequest voteSessionRequest);
    VoteSession getById(Long id);
}
