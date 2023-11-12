package com.sicredi.cooperativismo.service;

import com.sicredi.cooperativismo.domain.Affiliated;
import com.sicredi.cooperativismo.dto.request.AffiliatedRequest;
import com.sicredi.cooperativismo.exceptions.NotFoundException;
import com.sicredi.cooperativismo.infra.IAffiliatedRepository;
import com.sicredi.cooperativismo.mapper.IAffiliatedMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AffiliatedService implements IAffiliatedService {

    private final IAffiliatedRepository affiliatedRepository;
    private final IAffiliatedMapper affiliatedMapper;

    @Override
    public Affiliated createAffiliated(AffiliatedRequest affiliatedRequest) {
        Affiliated affiliated = affiliatedMapper.affiliatedRequestToAffiliated(affiliatedRequest);
        return this.affiliatedRepository.save(affiliated);
    }

    @Override
    public Affiliated getById(Long id) {
        return affiliatedRepository.findById(id).orElseThrow(() -> new NotFoundException("Associado não encontrado."));
    }
}
