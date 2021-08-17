package hello.hellospring.service.user;

import hello.hellospring.domain.user.UserDetailsVO;
import hello.hellospring.exception.UserNotFoundException;
import hello.hellospring.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Collections;

@RequiredArgsConstructor //초기화되지 않은 final 필드나 @NonNull이 붙은 필드에 대해 생성자를 생성해준다.
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetailsVO loadUserByUsername(String userId) {
        return userRepository
                .findByUserId(userId)
                .map(u ->
                        new UserDetailsVO(u, Collections.singleton(
                                new SimpleGrantedAuthority(u.getUserRole().getValue())
                        ))
                )
                .orElseThrow(() -> new UserNotFoundException(userId));
    }
}