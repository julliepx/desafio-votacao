package com.sicredi.cooperativismo.api;

import com.sicredi.cooperativismo.domain.Topic;
import com.sicredi.cooperativismo.dto.request.TopicRequest;
import com.sicredi.cooperativismo.service.ITopicService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/topics")
public class TopicController {

    @Autowired
    private ITopicService topicService;

    @PostMapping()
    public ResponseEntity<Topic> createTopic(@RequestBody @Valid TopicRequest topicRequest) {
        return new ResponseEntity<>(this.topicService.createTopic(topicRequest), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Topic> getTopicById(@PathVariable Long id) {
        return new ResponseEntity<>(topicService.getById(id), HttpStatus.OK);
    }
}
