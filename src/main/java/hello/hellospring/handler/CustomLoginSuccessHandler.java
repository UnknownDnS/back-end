package hello.hellospring.handler;

import hello.hellospring.domain.user.AuthConstants;
import hello.hellospring.domain.user.UserDetailsVO;
import hello.hellospring.domain.user.UserVO;
import hello.hellospring.utils.TokenUtils;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * CustomAuthenticationFilter의 핸들러
 */
@Log4j2
public class CustomLoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        final UserVO userVO = ((UserDetailsVO) authentication.getPrincipal()).getUserVO();
        final String token = TokenUtils.generateJwtToken(userVO);
        response.addHeader(AuthConstants.AUTH_HEADER, AuthConstants.TOKEN_TYPE+""+token);
        //SecurityContextHolder.getContext().setAuthentication(authentication);
        //response.sendRedirect("/about");
    }
}
