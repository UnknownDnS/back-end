package hello.hellospring.controller.user;

import hello.hellospring.domain.user.SignUpDTO;
import hello.hellospring.domain.user.UserListResponseDTO;
import hello.hellospring.domain.user.UserRole;
import hello.hellospring.domain.user.UserVO;
import hello.hellospring.service.user.UserService;
import hello.hellospring.utils.TokenUtils;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

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

    @NonNull //passwordEncoder가 null이 될 수 없다는 것을 의미
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
        userVO = userService.findByUserId(userVO.getUserId());
        if(userVO == null || !passwordEncoder.matches(userPw, userVO.getUserPw())){
            redirectAttributes.addFlashAttribute("rsMsg", "아이디 또는 비밀번호가 잘못되었습니다.");
            return "redirect:/user/loginView";
        }
        request.getSession().setAttribute("userVO", userVO);
        return "redirect:/index";
    }*/




    @GetMapping(value = "/init")
    public String createAdmin(@ModelAttribute UserVO userVO){
       /*
        userVO.setUserId("user@naver.com");
        userVO.setUserPw(passwordEncoder.encode("test"));
        userVO.setUserRole(UserRole.USER);
        if(userService.createUser(userVO) == null){
            log.error("Create Admin Error");
        }
*/

        userVO.setUserId("admin@naver.com");
        userVO.setUserPw(passwordEncoder.encode("test"));
        userVO.setUserRole(UserRole.ADMIN);
        if(userService.createUser(userVO) == null){
            log.error("Create Admin Error");
        }
        return "redirect:/index";
    }


    /**
     * 필터와 인터셉터 차이점
     * 피렅는 DispatcherServlet 앞에서 먼저 동작
     * 인터셉터는 DispatcherServlet 에서 Controller 사이에서 동작
     *
     */
    /**
     * ResponseBody vs ResponseEntity
     * ResponseBody 어노테이션은 HTTP 요청 몸체를 자바 객체로 변환하는 반면, ( 즉 parameter가 ResponseBody_type)
     * ResponseEntity 어노테이션은 HTTP 응답 몸체로 변환하는데 사용된다. (즉 return ResponseEntity_type)
     * RequestBody
     */
    @PostMapping(value="/signup")
    public ResponseEntity<String> signup(@RequestBody SignUpDTO signUpDTO){
        log.info(signUpDTO);

        return userService.findByUserId(signUpDTO.getUserId()).isPresent()
                ? ResponseEntity.badRequest().build()
                : ResponseEntity.ok(TokenUtils.generateJwtToken(userService.signup(signUpDTO)));
    }

    @GetMapping(value="/list")
    public ResponseEntity<UserListResponseDTO> findAll(){
        final UserListResponseDTO userListResponseDTO = UserListResponseDTO.builder()
                .userList(userService.findAll()).build();
        return ResponseEntity.ok(userListResponseDTO);
    }
}
