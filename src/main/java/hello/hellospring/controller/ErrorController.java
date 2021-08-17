package hello.hellospring.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * ResponseBody vs ResponseEntity
 * ResponseBody 어노테이션은 HTTP 요청 몸체를 자바 객체로 변환하는 반면, ( 즉 parameter가 ResponseBody_type)
 * ResponseEntity 어노테이션은 HTTP 응답 몸체로 변환하는데 사용된다. (즉 return ResponseEntity_type)
 */

@RestController
@RequestMapping(value="/error")
public class ErrorController {
    @GetMapping(value = "/unauthorized")
    public ResponseEntity<Void> unauthorized(){
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}
