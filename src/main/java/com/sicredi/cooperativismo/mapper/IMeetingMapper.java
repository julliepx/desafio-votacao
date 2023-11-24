package com.sicredi.cooperativismo.mapper;

import com.sicredi.cooperativismo.domain.Meeting;
import com.sicredi.cooperativismo.dto.request.MeetingRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IMeetingMapper {

    Meeting meetingRequestToMeeting(MeetingRequest meetingRequest);
}
