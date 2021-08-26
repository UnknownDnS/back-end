package com.unstar.backend.service;

import com.unstar.backend.domain.entity.User;
import com.unstar.backend.dto.request.LoginRequestDto;
import com.unstar.backend.dto.response.SignUpResponseDto;
import com.unstar.backend.dto.response.RootResponseDto;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User login(User user);

    RootResponseDto<SignUpResponseDto> signup(final LoginRequestDto loginRequestDTO);

    User createUser(User user);

    Optional<User> findByUserName(String userName);

    List<User> findAll();
}