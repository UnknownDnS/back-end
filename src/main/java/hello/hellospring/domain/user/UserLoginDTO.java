package hello.hellospring.domain.user;

import lombok.Data;

@Data
public class UserLoginDTO {
    private String userId;
    private String name;
    //private boolean loginResult=false;

    public UserLoginDTO(String userId, String name){
        this.userId = userId;
        this.name = name;
        //this.loginResult = false;
    }
}
