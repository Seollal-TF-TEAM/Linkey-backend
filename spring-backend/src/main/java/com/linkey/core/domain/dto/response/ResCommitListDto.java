package com.linkey.core.domain.dto.response;


import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
public class ResCommitListDto {
//임시 .... commit controller 수정시 다시 작성
    List<CommitList> commitList;

    public static class CommitList{
        private Long githubId;
    }
}
