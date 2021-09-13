package com.unstar.backend.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SignUpRequestDTO {

    @NotNull
    @Size(min = 3, max =50)
    private String userName;

    @JsonProperty(access =  JsonProperty.Access.WRITE_ONLY)
    @NotNull
    @Size(min = 3, max =100)
    private String userPw;

    @NotNull
    @Size(min = 3, max =50)
    private String nickName;

}
