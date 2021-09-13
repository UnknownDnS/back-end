package com.unstar.backend.controller;

import com.unstar.backend.dto.response.LoginResponseDTO;
import com.unstar.backend.config.jwt.TokenProvider;
import com.unstar.backend.dto.request.LoginRequestDTO;
import com.unstar.backend.dto.request.SignUpRequestDTO;
import com.unstar.backend.dto.response.RootResponseDTO;
import com.unstar.backend.dto.response.SignUpResponseDTO;
import com.unstar.backend.serviceImpl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api")
public class AuthController {

    private final UserServiceImpl userService;
    private final TokenProvider tokenProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;

    /**
     * 로그인
     *
     * @param loginRequestDto
     * @return
     */
    @PostMapping("/login")
    public RootResponseDTO<LoginResponseDTO> authorize(@Valid @RequestBody LoginRequestDTO loginRequestDto) {
        log.info("[login]");
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginRequestDto.getUserName(), loginRequestDto.getUserPw());
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.createToken(authentication);
        LoginResponseDTO dto = new LoginResponseDTO();
        dto.setToken(jwt);
        return new RootResponseDTO<LoginResponseDTO>()
                .code(HttpStatus.OK.value())
                .response(dto)
                .build();
    }

    /**
     * 회원가입
     *
     * @param signUpRequestDto
     * @return
     */
    @PostMapping("/signup")
    public RootResponseDTO<SignUpResponseDTO> signup(@Valid @RequestBody SignUpRequestDTO signUpRequestDto) {
        log.info("[signup]");
        SignUpResponseDTO dto = userService.signup(signUpRequestDto);
        return new RootResponseDTO<SignUpResponseDTO>()
                .code(HttpStatus.OK.value())
                .response(dto)
                .build();
    }

}
