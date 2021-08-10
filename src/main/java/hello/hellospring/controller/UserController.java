package hello.hellospring.controller;

import hello.hellospring.domain.User;
import hello.hellospring.domain.dto.UserLoginDTO;
import hello.hellospring.domain.dto.UserUpdateDTO;
import hello.hellospring.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/user") // This means URL's start with /user (after Application path)
@Slf4j
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService memberService){
        this.userService = memberService;
    }

    /**
     * 사용자 정보를 입력받아 로그인
     */
    @PostMapping("/login")
    public @ResponseBody UserLoginDTO login(@RequestParam String userId, @RequestParam String userPassword){
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        System.out.println("[info] /ser/login: "+ userId+", "+userPassword );
        User user = new User();
        user.setUserId(userId);
        user.setPassword(userPassword);
        return userService.validateUser(user);
    }

    /**
     * 사용자 정보를 입력받아 회원 가입
     */
    @PostMapping("/signup")
    public @ResponseBody User singUp(@RequestParam String userId,
                                     @RequestParam String userPassword,
                                     @RequestParam String userName) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        System.out.println("[info] /ser/signup: "+ userId+", "+userPassword +", " + userName);
        User user = new User();
        user.setUserId(userId);
        user.setPassword(userPassword);
        user.setName(userName);
        return userService.insertUser(user);
    }

    /**
     * 사용자 정보를 입력받아 업데이트
     */
    @PostMapping("/update")
    public @ResponseBody  UserUpdateDTO update(@RequestParam String userId,
                                @RequestParam String userPassword,
                                @RequestParam String userName) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        System.out.println("[info] /ser/update: "+ userId+", "+userPassword +", " + userName);
        User user = new User();
        user.setUserId(userId);
        user.setPassword(userPassword);
        user.setName(userName);
        return userService.updateUser(user);
    }

}
