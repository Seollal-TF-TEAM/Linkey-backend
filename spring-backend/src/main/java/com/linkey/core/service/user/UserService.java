package com.linkey.core.service.user;

import com.linkey.core.domain.dto.GitUserDto;

import java.util.List;

public interface UserService {
    List<GitUserDto> searchUsersByKeyword(String keyword);
}
