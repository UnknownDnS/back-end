package hello.hellospring.exception;

import lombok.Getter;

@Getter
public class InvalidUserNameException extends RuntimeException {
    public InvalidUserNameException(String message) {
        super(message);
    }
}
