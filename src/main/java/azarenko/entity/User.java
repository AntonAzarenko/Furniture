package azarenko.entity;


import org.hibernate.validator.constraints.Length;

import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * Класс хранит информацию о пользователе: ID, имя, почту(используеться как LOGIN), пароль, enabled(авторизован
 * ли пользователь если осуществляет переход по страницам), дату регистрации.
 *
 * @author Anton Azarenko
 */

public class User extends BaseEntity {

    private String name;

    private String email;


    @Length(min = 5)
    private String password;


    private boolean enabled = true;

    private Set<Role> roles;

    public void setRoles(Role roles) {
        this.roles = new HashSet<>();
        this.roles.add(roles);
    }

    private Date registered = new Date();

    public User(String name, String email, String password, boolean enabled, Role roles, Date registered) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.enabled = enabled;
        this.roles = Collections.singleton(roles);
        this.registered = registered;
    }

    public User(Long id, String name, String email, String password, boolean enabled, Role roles, Date registered) {
        super(id);
        this.name = name;
        this.email = email;
        this.password = password;
        this.enabled = enabled;
        this.roles = Collections.singleton(roles);
        this.registered = registered;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    /*public void setRoles(List<Role> roles) {
        this.roles = CollectionUtils.isEmpty(roles) ? Collections.emptySet() : EnumSet.copyOf(roles);;
    }*/

    public Date getRegistered() {
        return registered;
    }

    public void setRegistered(Date registered) {
        this.registered = registered;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (getName() != null ? !getName().equals(user.getName()) : user.getName() != null) return false;
        if (getEmail() != null ? !getEmail().equals(user.getEmail()) : user.getEmail() != null) return false;
        if (getPassword() != null ? !getPassword().equals(user.getPassword()) : user.getPassword() != null)
            return false;
        return getRoles() != null ? getRoles().equals(user.getRoles()) : user.getRoles() == null;
    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
        result = 31 * result + (getPassword() != null ? getPassword().hashCode() : 0);
        result = 31 * result + (getRoles() != null ? getRoles().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", enabled=" + enabled +
                ", roles=" + roles +
                ", registered=" + registered +
                '}';
    }
}
