package com.sicredi.cooperativismo.mapper;

import com.sicredi.cooperativismo.domain.Topic;
import com.sicredi.cooperativismo.domain.VoteSession;
import com.sicredi.cooperativismo.dto.request.TopicRequest;
import com.sicredi.cooperativismo.dto.request.VoteSessionRequest;

public interface IVoteSessionMapper {

    static VoteSession buildVoteSession(VoteSessionRequest voteSessionRequest) {
        VoteSession voteSession = VoteSession.builder()
                .topic(Topic.builder().id(voteSessionRequest.topicId()).build())
                .build();

        if(voteSessionRequest.endTime() != null) {
            voteSession.setEndTime(voteSessionRequest.endTime());
        }

        return voteSession;
    }
}
