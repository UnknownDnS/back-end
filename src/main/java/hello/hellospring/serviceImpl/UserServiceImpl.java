package hello.hellospring.serviceImpl;

import hello.hellospring.dto.response.SignUpResponseDto;
import hello.hellospring.dto.response.UserResponseDto;
import hello.hellospring.exception.ForbiddenException;
import hello.hellospring.exception.InvalidUserNameException;
import hello.hellospring.exception.UnAuthorizedException;
import hello.hellospring.utils.SecurityUtil;
import hello.hellospring.domain.entity.Authority;
import hello.hellospring.domain.entity.User;
import hello.hellospring.dto.request.SignUpRequestDto;
import hello.hellospring.domain.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;


@Service
@Slf4j
public class UserServiceImpl {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public SignUpResponseDto signup(SignUpRequestDto signUpRequestDto) {
        if (userRepository.findOneWithAuthoritiesByUserName(signUpRequestDto.getUserName()).orElse(null) != null) {
            throw new InvalidUserNameException("이미 가입되어 있는 유저입니다.");
        }

        //빌더 패턴의 장점
        Authority authority = Authority.builder().authorityName("ROLE_USER").build();

        User user = User.builder()
                .userName(signUpRequestDto.getUserName())
                .userPw(passwordEncoder.encode(signUpRequestDto.getUserPw()))
                .nickName(signUpRequestDto.getNickName())
                .authorities(Collections.singleton(authority))
                .build();

        User savedUser = userRepository.save(user);

        SignUpResponseDto dto = new SignUpResponseDto();
        dto.setNickName(savedUser.getNickName());
        dto.setUserName(savedUser.getUserName());

        return dto;
    }

    @Transactional(readOnly = true)
    public UserResponseDto getUserWithAuthorities(String username) {
        User user = userRepository.findByUserName(username)
                .orElseThrow(() -> new InvalidUserNameException("존재하지 않는 유저네임 입니다."));

        String loginUser = SecurityUtil.getCurrentUsername().get();
        if (!loginUser.equals("admin") && loginUser.equals(username)) {
            throw new ForbiddenException("조회 권한이 없습니다.");
        }

        return UserResponseDto.fromEntity(user);
    }
}