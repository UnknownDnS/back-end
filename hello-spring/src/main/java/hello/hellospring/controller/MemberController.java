package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberSerivce){
        this.memberService = memberSerivce;
    }

    @PostMapping("/login")
    public String login(@RequestParam("userId") String userId,
                        @RequestParam("userPassword") String userPassword){
        Member member = new Member();
        member.setUserId(userId);
        member.setUserPasswd(userPassword);
        boolean ret = memberService.validateUser(member);

        /*if(ret)
            return "index";
        else
            return "index";
            W
         */
        return null;
    }





}
