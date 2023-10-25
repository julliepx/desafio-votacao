package com.sicredi.cooperativismo.api;

import com.sicredi.cooperativismo.domain.Vote;
import com.sicredi.cooperativismo.dto.request.VoteRequest;
import com.sicredi.cooperativismo.service.IVoteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/votes")
public class VoteController {

    @Autowired
    private IVoteService voteService;

    @PostMapping()
    public ResponseEntity<Vote> vote(@RequestBody @Valid VoteRequest voteRequest) {
        return new ResponseEntity<>(this.voteService.vote(voteRequest), HttpStatus.CREATED);
    }
}
