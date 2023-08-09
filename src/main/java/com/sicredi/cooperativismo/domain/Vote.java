package com.sicredi.cooperativismo.domain;

import com.sicredi.cooperativismo.enums.VoteValueEnum;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
@Table(name = "vote")
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private VoteValueEnum value;

    @ManyToOne
    @JoinTable(name = "affiliated_vote", joinColumns = @JoinColumn(name = "vote_id"),
            inverseJoinColumns = @JoinColumn(name = "affiliated_id"))
    private Affiliated affiliated;
}
