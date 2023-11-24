package com.sicredi.cooperativismo.service;

import com.sicredi.cooperativismo.domain.Meeting;
import com.sicredi.cooperativismo.dto.request.MeetingRequest;

public interface IMeetingService {

    Meeting createMeeting(MeetingRequest meetingRequest);
    Meeting getById(Long id);
    void endMeeting(Long id);
}
