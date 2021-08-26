package hello.hellospring.controller;

import hello.hellospring.domain.entity.User;
import hello.hellospring.dto.response.RootResponseDto;
import hello.hellospring.dto.response.UserResponseDto;
import hello.hellospring.serviceImpl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @GetMapping("/user")
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
    public RootResponseDto<UserResponseDto> userInfo(@PathVariable String username) {
        UserResponseDto dto = userService.getUserWithAuthorities(username);
        return new RootResponseDto<UserResponseDto>()
                .code(HttpStatus.OK.value())
                .response(dto)
                .build();
    }
}