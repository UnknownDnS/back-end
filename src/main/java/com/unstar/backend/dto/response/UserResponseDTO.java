package com.unstar.backend.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.unstar.backend.constant.JsonFormatConstant;
import com.unstar.backend.domain.entity.User;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserResponseDTO {
    private String userName;

    private String nickName;

    @JsonFormat(pattern = JsonFormatConstant.YYYYMMDD_HHMMSS)
    private LocalDateTime createdAt;

    public static UserResponseDTO fromEntity(User user) {
        UserResponseDTO dto = new UserResponseDTO();
        dto.setNickName(user.getNickName());
        dto.setUserName(user.getUserName());
        dto.setCreatedAt(user.getCreatedAt());
        return dto;
    }
}
