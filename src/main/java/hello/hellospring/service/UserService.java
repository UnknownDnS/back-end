package hello.hellospring.service;

import hello.hellospring.dto.request.LoginRequestDto;
import hello.hellospring.domain.entity.User;
import hello.hellospring.dto.response.RootResponseDto;
import hello.hellospring.dto.response.SignUpResponseDto;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User login(User user);

    RootResponseDto<SignUpResponseDto> signup(final LoginRequestDto loginRequestDTO);

    User createUser(User user);

    Optional<User> findByUserName(String userName);

    List<User> findAll();
}