package com.sicredi.cooperativismo.service;

import com.sicredi.cooperativismo.domain.Topic;
import com.sicredi.cooperativismo.domain.Vote;
import com.sicredi.cooperativismo.dto.request.TopicRequest;
import com.sicredi.cooperativismo.dto.request.VoteRequest;
import com.sicredi.cooperativismo.infra.ITopicRepository;
import com.sicredi.cooperativismo.infra.IVoteRepository;
import com.sicredi.cooperativismo.mapper.ITopicMapper;
import com.sicredi.cooperativismo.mapper.IVoteMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VoteService implements IVoteService {

    private final IVoteRepository voteRepository;

    private final IVoteMapper voteMapper;

    @Override
    public Vote vote(VoteRequest voteRequest) {
        Vote vote = voteMapper.voteRequestToVote(voteRequest);

        return this.voteRepository.save(vote);
    }
}
