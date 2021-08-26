package hello.hellospring.controller;

import hello.hellospring.config.jwt.TokenProvider;
import hello.hellospring.dto.request.LoginRequestDto;
import hello.hellospring.dto.request.SignUpRequestDto;
import hello.hellospring.dto.response.LoginResponseDto;
import hello.hellospring.dto.response.RootResponseDto;
import hello.hellospring.dto.response.SignUpResponseDto;
import hello.hellospring.serviceImpl.UserServiceImpl;
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
    public RootResponseDto<LoginResponseDto> authorize(@Valid @RequestBody LoginRequestDto loginRequestDto) {
        log.info("[login]");
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginRequestDto.getUserName(), loginRequestDto.getUserPw());
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.createToken(authentication);
        LoginResponseDto dto = new LoginResponseDto();
        dto.setToken(jwt);
        return new RootResponseDto<LoginResponseDto>()
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
    public RootResponseDto<SignUpResponseDto> signup(@Valid @RequestBody SignUpRequestDto signUpRequestDto) {
        log.info("[signup]");
        SignUpResponseDto dto = userService.signup(signUpRequestDto);
        return new RootResponseDto<SignUpResponseDto>()
                .code(HttpStatus.OK.value())
                .response(dto)
                .build();
    }

}
