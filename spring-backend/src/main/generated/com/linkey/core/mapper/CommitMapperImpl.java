package com.linkey.core.mapper;

import com.linkey.core.domain.dto.request.ReqCreateCommitDto;
import com.linkey.core.domain.entity.Commit;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-25T20:13:36+0900",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17 (Oracle Corporation)"
)
@Component
public class CommitMapperImpl implements CommitMapper {

    @Override
    public Commit toEntity(ReqCreateCommitDto reqCreateCommitDto) {
        if ( reqCreateCommitDto == null ) {
            return null;
        }

        Commit.CommitBuilder commit = Commit.builder();

        commit.commitId( reqCreateCommitDto.getCommitId() );
        commit.githubCommitSha( reqCreateCommitDto.getGithubCommitSha() );
        commit.githubCommitMessage( reqCreateCommitDto.getGithubCommitMessage() );
        commit.githubCommitUserId( reqCreateCommitDto.getGithubCommitUserId() );
        commit.githubCommitDate( reqCreateCommitDto.getGithubCommitDate() );
        commit.todo( reqCreateCommitDto.getTodo() );
        commit.createdAt( reqCreateCommitDto.getCreatedAt() );
        commit.updatedAt( reqCreateCommitDto.getUpdatedAt() );

        return commit.build();
    }
}
