package com.sicredi.cooperativismo.api;

import com.sicredi.cooperativismo.dto.request.TopicRequest;
import com.sicredi.cooperativismo.dto.request.VoteSessionRequest;
import com.sicredi.cooperativismo.service.IVoteSessionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/vote-sessions")
public class VoteSessionController {

    @Autowired
    private IVoteSessionService voteSessionService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createVoteSession(@RequestBody @Valid VoteSessionRequest voteSessionRequest) {
        this.voteSessionService.createVoteSession(voteSessionRequest);
    }
}
