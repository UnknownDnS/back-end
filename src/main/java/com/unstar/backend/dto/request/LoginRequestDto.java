package com.unstar.backend.dto.request;

import lombok.Data;
import lombok.Getter;

@Data
public class LoginRequestDto {
    private String userName;
    private String userPw;
}
