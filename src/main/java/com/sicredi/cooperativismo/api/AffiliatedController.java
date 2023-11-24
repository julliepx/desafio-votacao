package com.sicredi.cooperativismo.api;

import com.sicredi.cooperativismo.domain.Affiliated;
import com.sicredi.cooperativismo.dto.request.AffiliatedRequest;
import com.sicredi.cooperativismo.service.IAffiliatedService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/affiliateds")
public class AffiliatedController {

    @Autowired
    private IAffiliatedService affiliatedService;

    @PostMapping()
    public ResponseEntity<Affiliated> createAffiliated(@RequestBody @Valid AffiliatedRequest affiliatedRequest) {
        return new ResponseEntity<>(this.affiliatedService.createAffiliated(affiliatedRequest), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Affiliated> getAffiliatedById(@PathVariable Long id) {
        return new ResponseEntity<>(affiliatedService.getById(id), HttpStatus.OK);
    }
}
