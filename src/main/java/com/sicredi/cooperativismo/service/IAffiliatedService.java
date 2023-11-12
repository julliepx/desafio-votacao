package com.sicredi.cooperativismo.service;

import com.sicredi.cooperativismo.domain.Affiliated;
import com.sicredi.cooperativismo.dto.request.AffiliatedRequest;

public interface IAffiliatedService {

    Affiliated createAffiliated(AffiliatedRequest affiliatedRequest);
    Affiliated getById(Long id);
}
