package com.sicredi.cooperativismo.dto.request;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class VoteSessionRequest {

    private LocalDateTime endTime;

    private Long topicId;
}
