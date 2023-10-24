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

    @OneToOne
    @JoinColumn(name = "topic_id")
    private Topic topic;

    @OneToOne
    @JoinTable(name = "vote_affiliated", joinColumns = @JoinColumn(name = "vote_id"),
            inverseJoinColumns = @JoinColumn(name = "affiliated_id"))
    private Affiliated affiliated;
}
