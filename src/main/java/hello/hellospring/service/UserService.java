package hello.hellospring.service;

import hello.hellospring.domain.User;
import hello.hellospring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    /**
     * 사용자 존재하는지 검증
     * return: 있으면 true, 없으면 false
     */
    public User validateUser(User user){
        User tmp_user = userRepository.findByUserId(user.getUserId());
        if (tmp_user.getUserPassword().equals(user.getUserPassword())){
            return tmp_user;
        }
        return null;
    }

    /**
     * 사용자 새로 추가
     * @param user
     * @return
     */
    public User insertUser(User user){
        return userRepository.save(user);
    }

    /**
     * 사용자 정보 업데이트
     * @param user
     * @return
     */
    public User updateUser(User user){
        if (validateUser(user) != null){
            userRepository.save(user);
        }
        return null;
    }
}
