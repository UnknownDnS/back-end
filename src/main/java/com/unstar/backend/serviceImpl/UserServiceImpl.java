package com.unstar.backend.serviceImpl;

import com.unstar.backend.dto.response.SignUpResponseDto;
import com.unstar.backend.dto.response.UserResponseDto;
import com.unstar.backend.service.UserService;
import com.unstar.backend.utils.SecurityUtil;
import com.unstar.backend.exception.ForbiddenException;
import com.unstar.backend.exception.InvalidUserNameException;
import com.unstar.backend.domain.entity.Authority;
import com.unstar.backend.domain.entity.User;
import com.unstar.backend.dto.request.SignUpRequestDto;
import com.unstar.backend.domain.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;


@Service
@Slf4j
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
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

    @Override
    public UserResponseDto getUserWithAuthorities(String username) {
        User user = userRepository.findByUserName(username)
                .orElseThrow(() -> new InvalidUserNameException("존재하지 않는 유저네임 입니다."));

        String loginUser = SecurityUtil.getCurrentUsername().get();
        if (!loginUser.equals("admin") && !loginUser.equals(username)) {
            throw new ForbiddenException("조회 권한이 없습니다.");
        }

        return UserResponseDto.fromEntity(user);
    }

    @Override
    public UserResponseDto getLoginUser() {
        String loginUser = SecurityUtil.getCurrentUsername().get();
        User user = userRepository.findByUserName(loginUser)
                .orElseThrow(() -> new InvalidUserNameException("존재하지 않는 유저네임 입니다."));
        return UserResponseDto.fromEntity(user);
    }
}