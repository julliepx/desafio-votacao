package com.sicredi.cooperativismo.service;

import com.sicredi.cooperativismo.domain.Topic;
import com.sicredi.cooperativismo.dto.request.TopicRequest;
import com.sicredi.cooperativismo.infra.ITopicRepository;
import com.sicredi.cooperativismo.mapper.ITopicMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService implements ITopicService {

    private final ITopicRepository topicRepository;

    @Autowired
    public TopicService(ITopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }
    @Override
    public Topic createTopic(TopicRequest topicRequest) {
        Topic topic = ITopicMapper.buildTopic(topicRequest);
        return this.topicRepository.save(topic);
    }
}
