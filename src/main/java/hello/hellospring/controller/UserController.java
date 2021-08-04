package hello.hellospring.controller;

import hello.hellospring.domain.User;
import hello.hellospring.domain.UserRole;
import hello.hellospring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService memberService){
        this.userService = memberService;
    }

    @PostMapping("/user/login")
    public String login(@RequestParam("userId") String userId,
                        @RequestParam("userPassword") String userPassword){
        User user = new User(userId, userPassword);
        user = userService.validateUser(user);
        if(user.getUserRole() == UserRole.ADMIN){
            return "admin.html";
        }
        return "index.html";
    }

}
