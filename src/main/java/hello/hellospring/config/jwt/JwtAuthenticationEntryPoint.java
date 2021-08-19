package hello.hellospring.config.jwt;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
//유효한 자격증명을 제공하지 않고 접근하려 할때 401 Unauthorized 에러를 리턴
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authenticationException) throws IOException{
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
    }

}
