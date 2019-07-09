package azarenka.entity;

import azarenka.entity.fitting.Loops;
import azarenka.entity.fitting.oforder.HandleOfOrder;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "fittings")
public class Fittings extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "handle_order_id")
    private HandleOfOrder handle;

    @OneToOne
    @JoinColumn(name = "loops")
    private Loops loops;

    @Column(name = "count")
    private int count;

    @Column(name = " price")
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "module_id")
    private Module module;

    public Fittings() {
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public HandleOfOrder getHandle() {
        return handle;
    }

    public void setHandle(HandleOfOrder handle) {
        this.handle = handle;
    }

    public Loops getLoops() {
        return loops;
    }

    public void setLoops(Loops loops) {
        this.loops = loops;
    }
}
