package azarenko.entity;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.data.annotation.Id;

public class BaseEntity implements Serializable {
    @Id
    private String id;

    public BaseEntity() {
    }

    public BaseEntity(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BaseEntity)) return false;
        BaseEntity that = (BaseEntity) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId());
    }
}
