package com.sicredi.cooperativismo.service;

import com.sicredi.cooperativismo.domain.Topic;
import com.sicredi.cooperativismo.dto.request.TopicRequest;
import com.sicredi.cooperativismo.exceptions.NotFoundException;
import com.sicredi.cooperativismo.infra.ITopicRepository;
import com.sicredi.cooperativismo.mapper.ITopicMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TopicService implements ITopicService {

    private final ITopicRepository topicRepository;

    private final ITopicMapper topicMapper;

    @Override
    public Topic createTopic(TopicRequest topicRequest) {
        Topic topic = topicMapper.topicRequestToTopic(topicRequest);
        return this.topicRepository.save(topic);
    }

    @Override
    public Topic getById(Long id) {
        return this.topicRepository.findById(id).orElseThrow(() -> new NotFoundException("A pauta não foi encontrada."));
    }
}
