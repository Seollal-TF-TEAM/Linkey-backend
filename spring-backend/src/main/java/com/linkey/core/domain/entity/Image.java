package com.linkey.core.domain.entity;

import com.linkey.core.domain.dto.ImageDto;
import com.linkey.core.domain.dto.request.ReqUpdateImageDto;
import com.linkey.core.global.exception.CustomException;
import com.linkey.core.global.exception.ErrorCode;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

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

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column
    private LocalDateTime updatedAt;

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

    public Image update(ReqUpdateImageDto reqUpdateImageDto) throws CustomException {
        if (reqUpdateImageDto.getProject().getProjectId() == 0
                && reqUpdateImageDto.getSprint().getSprintId() == 0) {
            throw new CustomException(ErrorCode.UPDATE_PARAMETER_IS_EMPTY);
        }

        if (reqUpdateImageDto.getProject().getProjectId() != 0) {
            this.setProject(Project.builder()
                    .projectId(reqUpdateImageDto.getProject().getProjectId())
                    .build()
            );
        }

        if (reqUpdateImageDto.getSprint().getSprintId() != 0) {
            this.setSprint(Sprint.builder()
                    .sprintId(reqUpdateImageDto.getSprint().getSprintId())
                    .build()
            );
        }

        return this;
    }
}
