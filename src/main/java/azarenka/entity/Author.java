package azarenka.entity;

import azarenka.entity.stillunused.User;

import java.util.Date;

public class Author extends User {
    public Author(String name, String email, String password, boolean enabled, Role roles, Date registered) {
        super(name, email, password, enabled, roles, registered);
    }
}
