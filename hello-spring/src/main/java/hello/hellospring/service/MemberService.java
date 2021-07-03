package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MySQLMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    private final MySQLMemberRepository memberRepository;

    @Autowired
    public MemberService(MySQLMemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    public boolean validateUser(Member member){
        /**
         * 멤버 아이디와 패스워드 검사
         * return: 있으면 true, 없으면 false
         */


        return false;
    }

}
