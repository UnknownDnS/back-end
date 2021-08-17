package hello.hellospring.config.filter;

import lombok.extern.log4j.Log4j2;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


//chain.doFilter를 기준으로 컨트롤러 실행하기 전에 실행하고 컨트롤러 끝나고 실행.
@Log4j2
public class HeaderFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse res = (HttpServletResponse) response;
        res.setHeader("Access-Control-Allow-Origin", "*");
        res.setHeader("Access-Control-Allow-Methods", "GET, POST");
        res.setHeader("Access-Control-Max-Age", "3600");
        res.setHeader(
                "Access-Control-Allow-Headers",
                "X-Requested-With, Content-Type, Authorization, X-XSRF-token"
        );
        res.setHeader("Access-Control-Allow-Credentials", "false");

        chain.doFilter(request, response);
    }

}