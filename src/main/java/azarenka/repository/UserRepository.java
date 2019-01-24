package azarenka.repository;

import azarenka.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User getByEmail(String email);

    int getIdByEmail(String login);

    List<User> getAll();

    boolean existsByName(String name);

    User getById(Long id);
}
