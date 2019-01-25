package azarenka.service.logic;

import azarenka.dto.UserDTO;
import azarenka.entity.User;
import azarenka.repository.UserRepository;
import azarenka.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public void save(User user) {
        repository.save(user);
    }

    @Override
    public boolean existsByUserName(String name) {
        return repository.existsByName(name);
    }

    @Override
    public void updatePassword(String password, Long id) {
        User user = repository.getById(id);
        user.setPassword(password);
        save(user);
    }

    @Override
    public void resetPassword(String email) {
        User user = repository.getByEmail(email).get();
        user.setPassword("password");
        save(user);
    }

    @Override
    public UserDTO get(Long id) {
        User user = repository.getById(id);
        UserDTO userDTO = new UserDTO();
        return userDTO.asUserDTO(user);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
