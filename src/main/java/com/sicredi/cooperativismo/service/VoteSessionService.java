package com.sicredi.cooperativismo.service;

import com.sicredi.cooperativismo.domain.Topic;
import com.sicredi.cooperativismo.domain.VoteSession;
import com.sicredi.cooperativismo.dto.request.TopicRequest;
import com.sicredi.cooperativismo.dto.request.VoteSessionRequest;
import com.sicredi.cooperativismo.infra.ITopicRepository;
import com.sicredi.cooperativismo.infra.IVoteSessionRepository;
import com.sicredi.cooperativismo.mapper.ITopicMapper;
import com.sicredi.cooperativismo.mapper.IVoteSessionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoteSessionService implements IVoteSessionService{

    private final IVoteSessionRepository voteSessionRepository;

    private final ITopicService topicService;

    @Autowired
    public VoteSessionService(IVoteSessionRepository voteSessionRepository, ITopicService topicService) {
        this.voteSessionRepository = voteSessionRepository;
        this.topicService = topicService;
    }
    @Override
    public VoteSession createVoteSession(VoteSessionRequest voteSessionRequest) {
        VoteSession voteSession = IVoteSessionMapper.buildVoteSession(voteSessionRequest);
        return this.voteSessionRepository.save(voteSession);
    }
}
