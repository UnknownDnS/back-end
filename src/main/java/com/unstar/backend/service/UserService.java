package com.unstar.backend.service;


import com.unstar.backend.dto.request.SignUpRequestDto;
import com.unstar.backend.dto.response.SignUpResponseDto;
import com.unstar.backend.dto.response.UserResponseDto;

public interface UserService {



    public SignUpResponseDto signup(SignUpRequestDto signUpRequestDto) ;

    public UserResponseDto getUserWithAuthorities(String username) ;

    public UserResponseDto getLoginUser() ;
}