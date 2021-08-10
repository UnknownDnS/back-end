package hello.hellospring.domain.dto;

import lombok.Data;

@Data
public class UserLoginDTO {
    private String userId;
    private String userName;
    //private boolean loginResult=false;

    public UserLoginDTO(String userId, String userName){
        this.userId = userId;
        this.userName = userName;
        //this.loginResult = false;
    }
}
