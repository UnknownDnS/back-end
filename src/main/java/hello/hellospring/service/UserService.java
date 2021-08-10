package hello.hellospring.service;

import hello.hellospring.domain.User;
import hello.hellospring.domain.dto.UserLoginDTO;
import hello.hellospring.domain.dto.UserUpdateDTO;
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
     * 같은 Id를 가진 기존 사용자가 있는지 확인
     * @param user
     * @return
     * 존재하면 true, 존재 하지않으면 false
     */
    public Boolean exist(User user){
        return userRepository.findByUserId(user.getUserId()) != null;
    }

    /**
     * 사용자가 존재하는지 검증
     * @param user
     * @return: 있으면 ture, 없으면 false
     */
    public UserLoginDTO validateUser(User user){
        User tmp_user = userRepository.findByUserId(user.getUserId());
        if (tmp_user.getPassword().equals(user.getPassword())){
            UserLoginDTO userLoginDTO = new UserLoginDTO(tmp_user.getUserId(), tmp_user.getName());
            //userLoginDTO.setLoginResult(true);
            return userLoginDTO;
        }
        return null;
    }

    /**
     * 사용자 새로 추가
     * @param user
     * @return 기존 사용자가 존재하면 null, 존재하지 않으면 해당 사용자 저장
     */
    public User insertUser(User user){
        if(exist(user)){
            return null;
        }
        return userRepository.save(user);
    }

    /**
     * 사용자 정보 업데이트
     * @param user
     * @return
     */
    public UserUpdateDTO updateUser(User user){
        if (validateUser(user) != null){
            User tmp_user = userRepository.save(user);
            UserUpdateDTO userUpdateDTO = new UserUpdateDTO(
                tmp_user.getUserId(), tmp_user.getName()
            );
            return userUpdateDTO;
        }
        return null;
    }
}
