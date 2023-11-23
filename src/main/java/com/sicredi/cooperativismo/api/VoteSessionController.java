package com.sicredi.cooperativismo.api;

import com.sicredi.cooperativismo.domain.VoteSession;
import com.sicredi.cooperativismo.dto.request.VoteSessionRequest;
import com.sicredi.cooperativismo.dto.response.VoteSessionResultResponse;
import com.sicredi.cooperativismo.service.IVoteSessionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/vote-sessions")
public class VoteSessionController {

    @Autowired
    private IVoteSessionService voteSessionService;

    @PostMapping()
    public ResponseEntity<VoteSession> createVoteSession(@RequestBody @Valid VoteSessionRequest voteSessionRequest) {
        return new ResponseEntity<>(this.voteSessionService.createVoteSession(voteSessionRequest), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VoteSession> getVoteSessionById(@PathVariable Long id) {
        return new ResponseEntity<>(voteSessionService.getById(id), HttpStatus.OK);
    }

    @GetMapping("/result/{id}")
    public ResponseEntity<VoteSessionResultResponse> getVoteSessionResults(@PathVariable Long id) {
        return new ResponseEntity<>(voteSessionService.getVoteSessionResults(id), HttpStatus.OK);
    }

    @PatchMapping("/end/{id}")
    public ResponseEntity<VoteSession> endVoteSession(@PathVariable Long id) {
        voteSessionService.endVoteSession(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
