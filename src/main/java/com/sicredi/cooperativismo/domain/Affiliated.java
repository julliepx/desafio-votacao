package com.sicredi.cooperativismo.domain;

import com.sicredi.cooperativismo.enums.AffiliatedStatusEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@Entity
@Table(name = "affiliated")
public class Affiliated {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String document;

    @Enumerated(EnumType.STRING)
    private AffiliatedStatusEnum canVote;
}
