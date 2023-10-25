package com.sicredi.cooperativismo.service;

import com.sicredi.cooperativismo.domain.Vote;
import com.sicredi.cooperativismo.dto.request.VoteRequest;

public interface IVoteService {

    Vote vote(VoteRequest voteRequest);
}
