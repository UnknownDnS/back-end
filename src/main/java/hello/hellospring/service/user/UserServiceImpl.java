package hello.hellospring.service.user;

import hello.hellospring.config.utils.SecurityUtil;
import hello.hellospring.domain.Authority;
import hello.hellospring.domain.user.User;
import hello.hellospring.domain.user.UserDTO;
import hello.hellospring.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Optional;


@Service
public class UserServiceImpl {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public User signup(UserDTO userDto) {
        if (userRepository.findOneWithAuthoritiesByUserName(userDto.getUserName()).orElse(null) != null) {
            throw new RuntimeException("이미 가입되어 있는 유저입니다.");
        }

        //빌더 패턴의 장점
        Authority authority = Authority.builder()
                .authorityName("ROLE_USER")
                .build();

        User user = User.builder()
                .userName(userDto.getUserName())
                .userPw(passwordEncoder.encode(userDto.getUserPw()))
                .nickName(userDto.getNickName())
                .authorities(Collections.singleton(authority))
                .build();

        user.setIsEnable(true);
        return userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public Optional<User> getUserWithAuthorities(String username) {
        return userRepository.findOneWithAuthoritiesByUserName(username);
    }

    @Transactional(readOnly = true)
    public Optional<User> getMyUserWithAuthorities() {
        return SecurityUtil.getCurrentUsername().flatMap(userRepository::findOneWithAuthoritiesByUserName);
    }
}