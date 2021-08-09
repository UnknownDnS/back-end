package hello.hellospring.domain.dto;

public class UserLoginDTO {
    private String userId;
    private String userName;
    private Boolean loginResult=false;

    public UserLoginDTO(String userId, String userName){
        this.userId = userId;
        this.userName = userName;
        this.loginResult = false;
    }

    public void setLoginResult(Boolean loginResult){
        this.loginResult = loginResult;
    }

    public Boolean getLoginResult(){
        return this.loginResult;
    }

}
