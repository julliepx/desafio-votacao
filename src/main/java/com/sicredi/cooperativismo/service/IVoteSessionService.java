package com.sicredi.cooperativismo.service;

import com.sicredi.cooperativismo.domain.VoteSession;
import com.sicredi.cooperativismo.dto.request.VoteSessionRequest;
import com.sicredi.cooperativismo.dto.response.VoteSessionResultResponse;

public interface IVoteSessionService {

    VoteSession createVoteSession(VoteSessionRequest voteSessionRequest);
    VoteSession getById(Long id);
    void endVoteSession(Long id);
    VoteSessionResultResponse getVoteSessionResults(Long voteSessionId);
}
