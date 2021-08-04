package hello.hellospring.service;

import hello.hellospring.domain.User;
import hello.hellospring.domain.UserRole;
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

    public User validateUser(User user){
        /**
         * 멤버 아이디와 패스워드 검사
         * return: 있으면 true, 없으면 false
         */
        User tmp_user = userRepository.findByUserId(user.getUserId());
        if (tmp_user.getUserPassword().equals(user.getUserPassword())){
            return tmp_user;
        }

        return null;
    }

}
