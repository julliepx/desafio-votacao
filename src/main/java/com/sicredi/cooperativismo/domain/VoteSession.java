package com.sicredi.cooperativismo.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "vote_session")
public class VoteSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime startTime = LocalDateTime.now();

    private LocalDateTime endTime = LocalDateTime.now().plusMinutes(1);

    @OneToOne
    @JoinColumn(name = "topic_id")
    private Topic topic;
}
