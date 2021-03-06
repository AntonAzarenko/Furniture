package azarenka.repository;

import azarenka.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> getByEmail(String email);

    int getIdByEmail(String login);

    boolean existsByName(String name);

    User getById(Long id);
}
