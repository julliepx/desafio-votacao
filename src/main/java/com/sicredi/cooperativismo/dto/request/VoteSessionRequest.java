package com.sicredi.cooperativismo.dto.request;

import java.time.LocalDateTime;

public class VoteSessionRequest {

    public LocalDateTime startTime = LocalDateTime.now();

    public LocalDateTime endTime = LocalDateTime.now().plusMinutes(1);

    public Long topicId;
}
