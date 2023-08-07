package com.sicredi.cooperativismo.mapper;

import com.sicredi.cooperativismo.domain.Topic;
import com.sicredi.cooperativismo.dto.request.TopicRequest;

public interface ITopicMapper {

    static Topic buildTopic(TopicRequest topicRequest) {
        return Topic.builder()
                .title(topicRequest.title())
                .build();
    }
}
