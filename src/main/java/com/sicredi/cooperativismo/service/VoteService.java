package com.sicredi.cooperativismo.service;

import com.sicredi.cooperativismo.domain.Affiliated;
import com.sicredi.cooperativismo.domain.Topic;
import com.sicredi.cooperativismo.domain.Vote;
import com.sicredi.cooperativismo.domain.VoteSession;
import com.sicredi.cooperativismo.dto.request.TopicRequest;
import com.sicredi.cooperativismo.dto.request.VoteRequest;
import com.sicredi.cooperativismo.infra.ITopicRepository;
import com.sicredi.cooperativismo.infra.IVoteRepository;
import com.sicredi.cooperativismo.mapper.ITopicMapper;
import com.sicredi.cooperativismo.mapper.IVoteMapper;
import com.sicredi.cooperativismo.validation.ValidationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VoteService implements IVoteService {

    private final IVoteRepository voteRepository;

    private final IVoteMapper voteMapper;

    private final IAffiliatedService affiliatedService;

    private final IVoteSessionService voteSessionService;

    @Override
    public Vote vote(VoteRequest voteRequest) {
        Affiliated affiliated = affiliatedService.getById(voteRequest.getAffiliatedId());
        VoteSession voteSession = voteSessionService.getById(voteRequest.getVoteSessionId());

        ValidationService.validateVoteSessionStatus(voteSession);
        ValidationService.validateAffiliatedVoteStatus(voteSession, affiliated);

        Vote vote = voteMapper.voteRequestToVote(voteRequest);
        voteSession.getVotes().add(vote);

        return this.voteRepository.save(vote);
    }
}
