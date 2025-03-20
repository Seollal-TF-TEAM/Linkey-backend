package com.linkey.core.security;

import org.springframework.security.authentication.AbstractAuthenticationToken;

public class CustomAuthentication extends AbstractAuthenticationToken {
    private final Object principal;  // 인증된 사용자 정보

    public CustomAuthentication(Object principal) {
        super(null);  // 권한 정보 없음
        this.principal = principal;  // 사용자의 GitHub 정보 저장
        setAuthenticated(true);  // 인증 완료 상태로 설정
    }

    @Override
    public Object getPrincipal() {
        return principal;  // 인증된 사용자 반환 (GitHub 사용자 정보)
    }

    @Override
    public Object getCredentials() {
        return null;  // OAuth 인증 방식이므로 비밀번호 없음
    }
}

