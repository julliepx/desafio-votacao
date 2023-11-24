package com.sicredi.cooperativismo.api;

import com.sicredi.cooperativismo.domain.Meeting;
import com.sicredi.cooperativismo.dto.request.MeetingRequest;
import com.sicredi.cooperativismo.service.IMeetingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/meetings")
public class MeetingController {

    @Autowired
    private IMeetingService meetingService;

    @PostMapping()
    public ResponseEntity<Meeting> createMeeting(@RequestBody @Valid MeetingRequest meetingRequest) {
        return new ResponseEntity<>(meetingService.createMeeting(meetingRequest), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Meeting> getMeetingById(@PathVariable Long id) {
        return new ResponseEntity<>(meetingService.getById(id), HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Meeting> endMeeting(@PathVariable Long id) {
        meetingService.endMeeting(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
