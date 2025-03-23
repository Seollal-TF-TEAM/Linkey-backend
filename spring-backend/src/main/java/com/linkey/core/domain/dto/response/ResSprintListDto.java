package com.linkey.core.domain.dto.response;

import com.linkey.core.domain.entity.Sprint;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
public class ResSprintListDto {
    private List<SingleSprint> sprints;

    @Builder
    @ToString
    @AllArgsConstructor
    public static class SingleSprint {
        long sprintId;
        String sprintName;
        LocalDate sprintStartAt;
        LocalDate sprintEndAt;
    }

    public static ResSprintListDto fromEntity(List<Sprint> sprintEntityList) {

        return ResSprintListDto.builder()
                .sprints(
                        sprintEntityList.stream()
                                .map((sprintEntity) -> SingleSprint.builder()
                                        .sprintId(sprintEntity.getSprintId())
                                        .sprintName(sprintEntity.getSprintName())
                                        .sprintStartAt(sprintEntity.getSprintStartAt())
                                        .sprintEndAt(sprintEntity.getSprintEndAt())
                                        .build()
                                ).toList()
                ).build();
    }
}
/*
예시 :
    ResSprintListDto.builder()
                    .sprints(List.of(
                            ResSprintListDto.SingleSprint.builder()
                                    .sprintId(123)
                                    .sprintName("name")
                                    .sprintStartAt(LocalDate.now())
                                    .sprintEndAt(LocalDate.now())
                                    .build()
                    ));
 */