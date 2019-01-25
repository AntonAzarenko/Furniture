package azarenka.service;

import azarenka.dto.UserDTO;
import azarenka.entity.User;

public interface UserService {

    void save(User user);

    boolean existsByUserName(String name);

    void updatePassword(String password, Long id);

    void resetPassword(String email);

    UserDTO get(Long id);

    void delete(Long id);
}
