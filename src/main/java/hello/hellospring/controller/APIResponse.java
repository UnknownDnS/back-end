package hello.hellospring.controller;

import lombok.Data;

@Data
public class APIResponse {
    private String resultType;
    private String errorMsg;
    private Object data;
}
