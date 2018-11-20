package azarenka.repository;

import azarenka.entity.stillunused.User;
import azarenka.repository.mybatis.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<String, User> {
    User getByEmail(String email);

    int getIdByEmail(String login);

    List<User> getAll();
}
