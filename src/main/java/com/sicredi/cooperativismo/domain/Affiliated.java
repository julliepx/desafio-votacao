package com.sicredi.cooperativismo.domain;

import com.sicredi.cooperativismo.enums.AffiliatedStatusEnum;
import jakarta.persistence.*;
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

    private String name;

    private String cpf;

    @Enumerated(EnumType.STRING)
    private AffiliatedStatusEnum canVote;
}
