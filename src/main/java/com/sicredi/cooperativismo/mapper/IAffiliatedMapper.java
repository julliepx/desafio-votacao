package com.sicredi.cooperativismo.mapper;

import com.sicredi.cooperativismo.domain.Affiliated;
import com.sicredi.cooperativismo.dto.request.AffiliatedRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IAffiliatedMapper {

    Affiliated affiliatedRequestToAffiliated(AffiliatedRequest affiliatedRequest);
}
