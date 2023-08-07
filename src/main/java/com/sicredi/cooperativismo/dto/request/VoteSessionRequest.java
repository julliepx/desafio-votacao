package com.sicredi.cooperativismo.dto.request;

import java.time.LocalDateTime;

public record VoteSessionRequest(LocalDateTime endTime, Long topicId) { }
