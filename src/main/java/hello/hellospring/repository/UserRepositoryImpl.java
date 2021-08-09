package hello.hellospring.repository;

import hello.hellospring.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import javax.persistence.EntityManager;
import java.util.List;

public class UserRepositoryImpl extends QuerydslRepositorySupport implements UserRepositoryCustom {

    public UserRepositoryImpl(){
        super(User.class);
    }

    @Override
    public List findAllLike(String keyword) {
        return null;
    }

    @Override
    @Autowired
    public void setEntityManager(EntityManager entityManager){
        super.setEntityManager(entityManager);
    }
}
