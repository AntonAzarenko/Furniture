package azarenka.entity.fitting.params;

import azarenka.entity.BaseEntity;
import azarenka.entity.fitting.Handle;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "handle_params")
public class HandleParams extends BaseEntity {

    @Column(name = "center_distance")
    private Integer centerDistance;

    @Column(name = "price")
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "id_handle", nullable = false)
    private Handle handle;

    public HandleParams() {
    }

    public Integer getCenterDistance() {
        return centerDistance;
    }

    public void setCenterDistance(Integer centerDistance) {
        this.centerDistance = centerDistance;
    }

    public Handle getHandle() {
        return handle;
    }

    public void setHandle(Handle handle) {
        this.handle = handle;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
