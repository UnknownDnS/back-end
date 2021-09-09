package com.unstar.backend.controller;

import com.unstar.backend.dto.response.RootResponseDto;
import com.unstar.backend.dto.response.UserResponseDto;
import com.unstar.backend.serviceImpl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {

    private final UserServiceImpl userService;

    /**
     * 전체 유저 정보 조회
     *
     * @return
     */
    @GetMapping("/user/all")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public RootResponseDto<UserResponseDto> userList() {
        return null;
    }

    /**
     * 유저 한명 정보 조회
     *
     * @param username
     * @return
     */
    @GetMapping("/user/{username}")
    public RootResponseDto<UserResponseDto> userByUsername(@PathVariable String username) {
        UserResponseDto dto = userService.getUserWithAuthorities(username);
        return new RootResponseDto<UserResponseDto>()
                .code(HttpStatus.OK.value())
                .response(dto)
                .build();
    }

    /**
     * 현재 로그인 된 유저 정보
     *
     * @return
     */
    @GetMapping("/user")
    public RootResponseDto<UserResponseDto> userInfo() {
        log.info("[/user]");
        UserResponseDto dto = userService.getLoginUser();
        return new RootResponseDto<UserResponseDto>()
                .code(HttpStatus.OK.value())
                .response(dto)
                .build();
    }
}