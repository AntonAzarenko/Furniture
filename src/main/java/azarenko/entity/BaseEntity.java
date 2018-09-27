package azarenko.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

public class BaseEntity implements Serializable {
    @Id
    private Long id;

    public BaseEntity() {
    }

    public BaseEntity(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
