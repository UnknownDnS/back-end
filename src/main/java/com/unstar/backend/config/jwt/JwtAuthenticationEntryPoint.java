package com.unstar.backend.config.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.unstar.backend.dto.response.RootResponseDTO;
import org.springframework.http.HttpStatus;
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
                         AuthenticationException authenticationException) throws IOException {

        RootResponseDTO<Object> dto = new RootResponseDTO<>()
                .code(HttpStatus.UNAUTHORIZED.value())
                .errorMsg("인증이 필요합니다.")
                .build();

        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().print(mapper.writeValueAsString(dto));
    }

}
