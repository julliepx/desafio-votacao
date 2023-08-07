package com.sicredi.cooperativismo.mapper;

import com.sicredi.cooperativismo.domain.Topic;
import com.sicredi.cooperativismo.dto.request.TopicRequest;
import org.mapstruct.Mapper;

import java.time.LocalDateTime;

@Mapper(componentModel = "spring")
public interface ITopicMapper {

    Topic topicRequestToTopic(TopicRequest topicRequest);
}
