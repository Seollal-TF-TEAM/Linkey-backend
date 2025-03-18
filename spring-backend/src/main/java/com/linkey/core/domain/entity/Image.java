package com.linkey.core.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "images")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "img_seq")
    @SequenceGenerator(name = "img_seq", sequenceName = "img_seq_id", allocationSize = 1)
    private long imgId;

    @Column(nullable = false, length = 256)
    private String imageUrl;

    @Column(nullable = false, length = 512)
    private String imagePath;

    @Column(nullable = false)
    private long fileSize;

    @Column(nullable = false, length = 50)
    private String fileType;

    @Column(nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "projectId")
    private Project project;

    @ManyToOne
    @JoinColumn(name = "sprintId")
    private Sprint sprint;
}
