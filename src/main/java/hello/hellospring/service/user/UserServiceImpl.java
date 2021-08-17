package hello.hellospring.service.user;

import hello.hellospring.domain.user.SignUpDTO;
import hello.hellospring.domain.user.UserRole;
import hello.hellospring.domain.user.UserVO;
import hello.hellospring.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserVO login(UserVO userVO) {
        return userRepository.findByUserIdAndUserPw(userVO.getUserId(), userVO.getUserPw());
    }

    @Override
    public UserVO createUser(UserVO userVO) {
        return userRepository.save(userVO);
    }

    @Override
    public UserVO signup(final SignUpDTO signUpDTO) {
        final UserVO userVO = UserVO.builder()
                .userId(signUpDTO.getUserId())
                .userPw(passwordEncoder.encode(signUpDTO.getUserPw()))
                .userRole(UserRole.USER)
                .build();

        return userRepository.save(userVO);
    }


    @Override
    public Optional<UserVO> findByUserId(final String userId){
        return userRepository.findByUserId(userId);
    }

    @Override
    public List<UserVO> findAll(){
        return userRepository.findAll();
    }

}