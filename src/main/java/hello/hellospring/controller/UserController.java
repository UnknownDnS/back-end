package hello.hellospring.controller;

import hello.hellospring.domain.User;
import hello.hellospring.domain.UserRole;
import hello.hellospring.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
//@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService memberService){
        this.userService = memberService;
    }

    /**
     * 사용자 정보를 입력받아 로그인
     * @param id
     * @param userPassword
     * @return
     */
    @PostMapping("/user/login")
    public User login(@RequestParam("id") String id,
                        @RequestParam("userPassword") String userPassword){
        User user = new User();
        user.setId(id);
        user.setUserPassword(userPassword);
        return userService.validateUser(user);
    }


    /**
     * 사용자 정보를 입력받아 회원 가입
     * @param id
     * @param userPassword
     * @param userName
     * @param role
     * @return
     */
    @PostMapping("/user/signUp")
    public User singUp(@RequestParam("id") String id,
                       @RequestParam("userPassword") String userPassword,
                       @RequestParam("userName") String userName,
                       @RequestParam("userRole") UserRole role) {
        User user = new User();
        user.setId(id);
        user.setUserPassword(userPassword);
        user.setUserName(userName);
        user.setUserRole(role);
        user.setCreatedAt(new Date());
        user.setModifiedAt(new Date());
        return userService.insertUser(user);
    }

    /**
     * 사용자 정보를 입력받아 업데이트
     * @param id
     * @param userPassword
     * @param userName
     * @param role
     * @return
     */
    @PostMapping("/user/update")
    public User update(@RequestParam("id") String id,
                       @RequestParam("userPassword") String userPassword,
                       @RequestParam("userName") String userName,
                       @RequestParam("userRole") UserRole role) {
        User user = new User();
        user.setId(id);
        user.setUserPassword(userPassword);
        user.setUserName(userName);
        user.setUserRole(role);
        user.setCreatedAt(new Date());
        user.setModifiedAt(new Date());
        return userService.updateUser(user);
    }

}
