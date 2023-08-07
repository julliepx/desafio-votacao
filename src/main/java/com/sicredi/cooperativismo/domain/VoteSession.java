package com.sicredi.cooperativismo.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "vote_session")
public class VoteSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Builder.Default
    private LocalDateTime startTime = LocalDateTime.now();

    @Builder.Default
    private LocalDateTime endTime = LocalDateTime.now().plusMinutes(1);

    @OneToOne
    @JoinColumn(name = "topic_id")
    private Topic topic;
}
