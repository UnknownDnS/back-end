package hello.hellospring.controller.user;

import hello.hellospring.domain.user.UserRole;
import hello.hellospring.domain.user.UserVO;
import hello.hellospring.service.user.UserService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
import hello.hellospring.domain.User;
import hello.hellospring.domain.user.UserLoginDTO;
import hello.hellospring.domain.user.UserUpdateDTO;
import hello.hellospring.service.user.UserService;
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
     *
    @PostMapping("/login")
    public @ResponseBody UserLoginDTO login(@RequestParam String userId, @RequestParam String password){
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request


        System.out.println("[info] /user/login: "+ userId+", "+password );
        User user = new User();
        user.setUserId(userId);
        user.setPassword(password);
        return userService.validateUser(user);
    }

    /**
     * 사용자 정보를 입력받아 회원 가입
     *
    @PostMapping("/signup")
    public @ResponseBody User singUp(@RequestParam String userId,
                                     @RequestParam String password,
                                     @RequestParam String name) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        System.out.println("[info] /user/signup: "+ userId+", "+password +", " + name);
        User user = new User();
        user.setUserId(userId);
        user.setPassword(password);
        user.setName(name);
        return userService.insertUser(user);
    }

    /**
     * 사용자 정보를 입력받아 업데이트
     *
    @PostMapping("/update")
    public @ResponseBody  UserUpdateDTO update(@RequestParam String userId,
                                @RequestParam String password,
                                @RequestParam String name) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        System.out.println("[info] /user/update: "+ userId+", "+password +", " + name);
        User user = new User();
        user.setUserId(userId);
        user.setPassword(password);
        user.setName(name);
        return userService.updateUser(user);
    }

}*/

@RequiredArgsConstructor
@Controller
@RequestMapping(value = "/user")
@Log4j2
public class UserController {

    private final UserService userService;

    @NonNull
    private BCryptPasswordEncoder passwordEncoder;

    @GetMapping(value = "/loginView")
    public String loginView(){
        return "user/login";
    }

    /*
    @PostMapping(value = "/login")
    public String login(HttpServletRequest request, RedirectAttributes redirectAttributes, @ModelAttribute UserVO userVO){
        log.error("@@@");
        String userPw = userVO.getUserPw();
        userVO = userService.findUserByUserEmail(userVO.getUserEmail());
        if(userVO == null || !passwordEncoder.matches(userPw, userVO.getUserPw())){
            redirectAttributes.addFlashAttribute("rsMsg", "아이디 또는 비밀번호가 잘못되었습니다.");
            return "redirect:/user/loginView";
        }
        request.getSession().setAttribute("userVO", userVO);
        return "redirect:/index";
    }
    */

    @GetMapping(value = "/init")
    public String createAdmin(@ModelAttribute UserVO userVO){
        userVO.setUserEmail("user@naver.com");
        userVO.setUserPw(passwordEncoder.encode("test"));
        userVO.setUserRole(UserRole.USER);
        if(userService.createUser(userVO) == null){
            log.error("Create Admin Error");
        }

        userVO.setUserEmail("admin@naver.com");
        userVO.setUserPw(passwordEncoder.encode("test"));
        userVO.setUserRole(UserRole.ADMIN);
        if(userService.createUser(userVO) == null){
            log.error("Create Admin Error");
        }
        return "redirect:/index";
    }

}
