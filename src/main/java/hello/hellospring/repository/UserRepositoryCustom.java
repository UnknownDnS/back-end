package hello.hellospring.repository;

import java.util.List;

public interface UserRepositoryCustom {
    List findAllLike(String keyword);

}
