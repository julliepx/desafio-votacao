package com.sicredi.cooperativismo.domain;

import com.sicredi.cooperativismo.enums.MeetingStatusEnum;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@Entity
@Table(name = "meeting")
public class Meeting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Builder.Default
    private LocalDateTime startTime = LocalDateTime.now();

    private LocalDateTime endTime;
    
    @Enumerated(EnumType.STRING)
    private MeetingStatusEnum status;

    @OneToMany
    @JoinTable(name = "meeting_topics", joinColumns = @JoinColumn(name = "meeting_id"),
            inverseJoinColumns = @JoinColumn(name = "topic_id"))
    private List<Topic> topics;
}

