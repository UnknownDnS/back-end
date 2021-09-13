package com.unstar.backend.service;


import com.unstar.backend.dto.request.SignUpRequestDTO;
import com.unstar.backend.dto.response.SignUpResponseDTO;
import com.unstar.backend.dto.response.UserResponseDTO;

public interface UserService {



    public SignUpResponseDTO signup(SignUpRequestDTO signUpRequestDto) ;

    public UserResponseDTO getUserWithAuthorities(String username) ;

    public UserResponseDTO getLoginUser() ;
}