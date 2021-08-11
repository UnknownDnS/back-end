package hello.hellospring.domain.dto;

public class UserUpdateDTO {

    private String userId;
    private String name;

    public UserUpdateDTO(String userId, String name){
        this.userId = userId;
        this.name = name;
    }
}
