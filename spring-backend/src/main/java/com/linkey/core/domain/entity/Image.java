package com.linkey.core.domain.entity;

import com.linkey.core.domain.dto.ImageDto;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Builder
@AllArgsConstructor
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

    public static Image toEntity(ImageDto dto) {
        return Image.builder()
                .imgId(dto.getImgId())
                .imageUrl(dto.getImageUrl())
                .imagePath(dto.getImagePath())
                .fileSize(dto.getFileSize())
                .fileType(dto.getFileType())
                .createdAt(dto.getCreatedAt())
                .project(new Project(dto.getProjectId()))
                .sprint(new Sprint(dto.getSprintId()))
                .build();
    }
}
