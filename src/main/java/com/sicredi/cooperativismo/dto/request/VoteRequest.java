package com.sicredi.cooperativismo.dto.request;

import com.sicredi.cooperativismo.enums.VoteValueEnum;
import lombok.Data;

@Data
public class VoteRequest {
    private VoteValueEnum value;
    private Long topicId;
    private Long affiliatedId;
}
