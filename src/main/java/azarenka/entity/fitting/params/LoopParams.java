package azarenka.entity.fitting.params;

import azarenka.entity.BaseEntity;
import azarenka.entity.fitting.Loops;
import azarenka.entity.fitting.TypeLoop;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "loops_params")
public class LoopParams extends BaseEntity {

    @Column(name = "angle")
    private String angle;

    @Column(name = "type_loop")
    private TypeLoop typeLoop;

    @Column(name = "micro_Lift")
    private boolean microLift;

    @Column(name = "price")
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "id_loop", nullable = false)
    private Loops loops;

    public LoopParams() {
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getAngle() {
        return angle;
    }

    public void setAngle(String angle) {
        this.angle = angle;
    }

    public TypeLoop getTypeLoop() {
        return typeLoop;
    }

    public void setTypeLoop(TypeLoop typeLoop) {
        this.typeLoop = typeLoop;
    }

    public boolean isMicroLift() {
        return microLift;
    }

    public void setMicroLift(boolean microLift) {
        this.microLift = microLift;
    }

    public Loops getLoops() {
        return loops;
    }

    public void setLoops(Loops loops) {
        this.loops = loops;
    }
}
