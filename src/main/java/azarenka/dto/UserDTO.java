package azarenka.dto;

import azarenka.entity.User;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class UserDTO {

    private String id;

    private String username;

    public User asUser(UserDTO userDTO){
        return null;
    }

    public UserDTO asUserDTO(User user){
        return null;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDTO userDTO = (UserDTO) o;
        return id.equals(userDTO.id) &&
                username.equals(userDTO.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username);
    }
}
