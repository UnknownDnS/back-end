package hello.hellospring.config.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.hellospring.domain.user.UserVO;
import hello.hellospring.exception.InputNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * UsernamePasswordAuthenticationFilter
 * 인증 폼 제출을 처리한다.
 * 전송이 오면 AuthenticationFilter로 요청이 먼저오고 id, pw 기반으로 UserPasswordAuthenticationToken을 발급
 *
 */
@Slf4j
public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    public CustomAuthenticationFilter(AuthenticationManager authenticationManager){
        super.setAuthenticationManager(authenticationManager);
    }

    /**
     * 실제 인증(authentication)을 수행한다.
     * @param request
     * @param response
     * @return
     * @throws AuthenticationException
     */
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException{
        /**
         * UsernamePasswordAuthenticationToken
         * Authentication 구현체로 username, password의 간단한 표현을 위해 설계됨
         *
         */
        UsernamePasswordAuthenticationToken authRequest;
        try {
            /**입력값 검증*/
            final UserVO userVO= new ObjectMapper().readValue(request.getInputStream(),UserVO.class);
            authRequest = new UsernamePasswordAuthenticationToken(userVO.getUserId(), userVO.getUserPw());
        }catch (IOException exception){
            throw new InputNotFoundException();
        }

        /**
         * UsernamePasswordAuthenticationFilter의 subclass(여기서 CustomAuthenticationFilter)가
         * 인증 요청 details 속성에다 설정을 할 수 있도록한다.
         */
        setDetails(request, authRequest);
        return this.getAuthenticationManager().authenticate(authRequest);
    }

}
