package hello.hellospring.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import hello.hellospring.constant.JsonFormatConstant;
import hello.hellospring.domain.entity.User;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserResponseDto {
    private String userName;

    private String nickName;

    @JsonFormat(pattern = JsonFormatConstant.YYYYMMDD_HHMMSS)
    private LocalDateTime createdAt;

    public static UserResponseDto fromEntity(User user) {
        UserResponseDto dto = new UserResponseDto();
        dto.setNickName(user.getNickName());
        dto.setUserName(user.getUserName());
        dto.setCreatedAt(user.getCreatedAt());
        return dto;
    }
}
