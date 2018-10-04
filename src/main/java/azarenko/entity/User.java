package azarenko.entity;



import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class User extends BaseEntity {

    private String name;

    private String email;

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

    public User(String id, String name, String email, String password, boolean enabled, Role roles, Date registered) {
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
