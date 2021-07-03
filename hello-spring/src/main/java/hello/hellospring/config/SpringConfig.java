package hello.hellospring.config;


import hello.hellospring.repository.MemberRepositoryi;
import hello.hellospring.repository.MySQLMemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    @Bean
    public MemberRepositoryi memberRepository(){
        return new MySQLMemberRepository();
    }

    @Bean
    public MemberService memberService(){
        return new MemberService((MySQLMemberRepository) memberRepository());
    }
}
