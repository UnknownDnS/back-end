package com.unstar.backend.controller;

import com.unstar.backend.dto.response.RootResponseDTO;
import com.unstar.backend.dto.response.UserResponseDTO;
import com.unstar.backend.service.UserService;
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

    private final UserService userService;

    /**
     * 전체 유저 정보 조회
     *
     * @return
     */
    @GetMapping("/user/all")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public RootResponseDTO<UserResponseDTO> userList() {
        return null;
    }

    /**
     * 유저 한명 정보 조회
     *
     * @param username
     * @return
     */
    @GetMapping("/user/{username}")
    public RootResponseDTO<UserResponseDTO> userByUsername(@PathVariable String username) {
        UserResponseDTO dto = userService.getUserWithAuthorities(username);
        return new RootResponseDTO<UserResponseDTO>()
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
    public RootResponseDTO<UserResponseDTO> userInfo() {
        log.info("[/user]");
        UserResponseDTO dto = userService.getLoginUser();
        return new RootResponseDTO<UserResponseDTO>()
                .code(HttpStatus.OK.value())
                .response(dto)
                .build();
    }
}