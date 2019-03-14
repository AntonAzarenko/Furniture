package azarenka.entity.furnitures.params;

import azarenka.entity.BaseEntity;
import azarenka.entity.furnitures.Handle;
import azarenka.entity.furnitures.HandleColor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "handle_params")
public class HandleParams extends BaseEntity {

    @Column(name = "center_distance")
    private Integer centerDistance;

    @CollectionTable(name = "handle_colors", joinColumns = @JoinColumn(name = "id_handle"))
    @Column(name = "color")
    @Enumerated(EnumType.STRING)
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<HandleColor> color;

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

    public Set<HandleColor> getColor() {
        return color;
    }

    public void setColor(Set<HandleColor> color) {
        this.color = color;
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
