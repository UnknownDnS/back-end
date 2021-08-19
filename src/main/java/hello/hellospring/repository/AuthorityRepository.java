package hello.hellospring.repository;

import hello.hellospring.domain.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, String> {
}
