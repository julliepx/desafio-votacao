package com.sicredi.cooperativismo.service;

import com.sicredi.cooperativismo.domain.Affiliated;
import com.sicredi.cooperativismo.domain.Vote;
import com.sicredi.cooperativismo.domain.VoteSession;
import com.sicredi.cooperativismo.dto.request.VoteSessionRequest;
import com.sicredi.cooperativismo.dto.response.VoteSessionResultResponse;
import com.sicredi.cooperativismo.enums.VoteSessionStatusEnum;
import com.sicredi.cooperativismo.enums.VoteValueEnum;
import com.sicredi.cooperativismo.exceptions.NotFoundException;
import com.sicredi.cooperativismo.infra.IVoteSessionRepository;
import com.sicredi.cooperativismo.mapper.IVoteSessionMapper;
import com.sicredi.cooperativismo.stubs.VoteSessionStub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class VoteSessionServiceTest {

    @InjectMocks
    private VoteSessionService voteSessionService;
    @Mock
    private IVoteSessionRepository voteSessionRepository;
    @Mock
    private IVoteSessionMapper voteSessionMapper;

    private VoteSession voteSession;
    private VoteSessionRequest voteSessionRequest;

    @BeforeEach
    void setup() {
        this.voteSession = VoteSessionStub.buildVoteSession();
        this.voteSessionRequest = VoteSessionStub.buildVoteSessionRequest();
    }

    @Test
    void shouldGetVoteSessionResults() {
        List<Vote> votes = new ArrayList<>();
        votes.add(new Vote(1L, VoteValueEnum.YES, new Affiliated()));
        votes.add(new Vote(2L, VoteValueEnum.YES, new Affiliated()));
        votes.add(new Vote(3L, VoteValueEnum.NO, new Affiliated()));
        voteSession.setVotes(votes);

        when(voteSessionRepository.findById(1L)).thenReturn(Optional.of(voteSession));

        VoteSessionResultResponse result = voteSessionService.getVoteSessionResults(1L);

        assertAll("votingResult",
                () -> assertEquals(VoteSessionStatusEnum.APPROVED, result.getStatus()),
                () -> assertEquals(3, result.getTotalVotes()),
                () -> assertEquals(2, result.getYesVotes()),
                () -> assertEquals(1, result.getNoVotes())
        );
        verify(voteSessionRepository).findById(1L);
    }

    @Test
    void shouldThrowNotFoundExceptionWhenGettingResultsIfVoteSessionDoesNotExist() {
        when(voteSessionRepository.findById(666L)).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> voteSessionService.getVoteSessionResults(666L));
        verify(voteSessionRepository).findById(666L);
    }

    @Test
    void shouldGetVoteSessionById() {
        when(voteSessionRepository.findById(1L)).thenReturn(Optional.of(voteSession));
        VoteSession secondVoteSession = voteSessionService.getById(1L);

        assertEquals(voteSession.getId(), secondVoteSession.getId());
        verify(voteSessionRepository).findById(1L);
    }

    @Test
    void shouldThrowNotFoundExceptionWhenGettingVoteSessionByNonExistingId() {
        when(voteSessionRepository.findById(999L)).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> voteSessionService.getById(999L));
        verify(voteSessionRepository).findById(999L);
    }

    @Test
    void shouldCreateVoteSession() {
        when(voteSessionMapper.voteSessionRequestToVoteSession(voteSessionRequest)).thenReturn(voteSession);
        when(voteSessionRepository.save(any(VoteSession.class))).thenReturn(voteSession);

        VoteSession savedVoteSession = voteSessionService.createVoteSession(voteSessionRequest);

        assertEquals(voteSessionRequest.getTopicId(), savedVoteSession.getTopic().getId());
        verify(voteSessionRepository, times(1)).save(any(VoteSession.class));
    }

//    @Test
//    void shouldReturnNotFoundExceptionWhenCreatingVoteSessionAndTopicDoesNotExist() {
//        when(voteSessionMapper.voteSessionRequestToVoteSession(voteSessionRequest)).thenReturn(voteSession);
//        when(voteSessionRepository.save(any(VoteSession.class))).thenReturn(voteSession);
//
//
//        VoteSession savedVoteSession = voteSessionService.createVoteSession(voteSessionRequest);
//
//        assertEquals(voteSessionRequest.getTopicId(), savedVoteSession.getTopic().getId());
//        verify(voteSessionRepository, times(1)).save(any(VoteSession.class));
//    }
}