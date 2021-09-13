package com.unstar.backend.config.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.unstar.backend.dto.response.RootResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException {

        RootResponseDTO<Object> dto = new RootResponseDTO<>()
                .code(HttpStatus.FORBIDDEN.value())
                .errorMsg("접근 권한이 없습니다.")
                .build();

        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().print(mapper.writeValueAsString(dto));
    }

}
