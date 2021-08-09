package hello.hellospring.domain.dto;

public class UserUpdateDTO {

    private String userId;
    private String userName;

    public UserUpdateDTO(String userId, String userName){
        this.userId = userId;
        this.userName = userName;
    }
}
