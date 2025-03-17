package com.linkey.core.domain.dto;

import lombok.Data;

@Data
public class GitUser {
    private String login;       // GitHub 사용자명
    private Long id;            // GitHub 사용자 ID
    private String avatar_url;  // 프로필 이미지
    private String html_url;    // GitHub URL
    private String name;        // 사용자 이름
    private String email;       // 이메일 (OAuth Scope 필요)
}
