package com.sicredi.cooperativismo.stubs;

import com.sicredi.cooperativismo.domain.Topic;
import com.sicredi.cooperativismo.enums.TopicStatusEnum;

public interface ITopicStub {

    static Topic buildTopic() {
        return Topic.builder()
                .id(1L)
                .title("Topic One")
                .status(TopicStatusEnum.IN_PROGRESS)
                .build();
    }
}
