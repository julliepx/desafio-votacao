package com.sicredi.cooperativismo.service;

import com.sicredi.cooperativismo.domain.Meeting;
import com.sicredi.cooperativismo.exceptions.NotFoundException;
import com.sicredi.cooperativismo.infra.IMeetingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MeetingService implements IMeetingService {

    private final IMeetingRepository meetingRepository;

    public Meeting getById(Long id) {
        return this.meetingRepository.findById(id).orElseThrow(() -> new NotFoundException("A assembleia não foi encontrada."));
    }
}
