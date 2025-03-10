package com.linkey.core.domain;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@EqualsAndHashCode
public class TeamMemberId implements Serializable {
    private Integer teamSeqId;
    private Integer teamId;
}
