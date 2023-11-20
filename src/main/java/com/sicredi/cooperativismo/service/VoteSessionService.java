package com.sicredi.cooperativismo.service;

import com.sicredi.cooperativismo.domain.VoteSession;
import com.sicredi.cooperativismo.dto.request.VoteSessionRequest;
import com.sicredi.cooperativismo.exceptions.NotFoundException;
import com.sicredi.cooperativismo.infra.IVoteSessionRepository;
import com.sicredi.cooperativismo.mapper.IVoteSessionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VoteSessionService implements IVoteSessionService{

    private final IVoteSessionRepository voteSessionRepository;

    private final IVoteSessionMapper voteSessionMapper;

    @Override
    public VoteSession createVoteSession(VoteSessionRequest voteSessionRequest) {
        VoteSession voteSession = voteSessionMapper.voteSessionRequestToVoteSession(voteSessionRequest);

        return this.voteSessionRepository.save(voteSession);
    }

    @Override
    public VoteSession getById(Long id) {
        return this.voteSessionRepository.findById(id).orElseThrow(() -> new NotFoundException("A sessão de votação não foi encontrada."));
    }
}
