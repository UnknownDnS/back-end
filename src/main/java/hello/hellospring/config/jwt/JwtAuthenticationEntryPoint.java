package hello.hellospring.config.jwt;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.json.simple.JSONObject;
@Component
//유효한 자격증명을 제공하지 않고 접근하려 할때 401 Unauthorized 에러를 리턴
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authenticationException) throws IOException{

        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType("application/json;charset=utf-8");

        JSONObject json = new JSONObject();
        json.put("code", "401");
        json.put("message", "UNAUTHORIZED");

        response.getWriter().print(json);
    }

}
