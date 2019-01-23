package azarenka.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "edge_material")
public class EdgeMaterial extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(name = "side", nullable = false)
    private EdgeSide edgeSide;

    @OneToOne
    @JoinColumn(name = "edge_id")
    private Edge edge;

    public EdgeMaterial() {
    }

    public EdgeSide getEdgeSide() {
        return edgeSide;
    }

    public void setEdgeSide(EdgeSide edgeSide) {
        this.edgeSide = edgeSide;
    }

    public Edge getEdge() {
        return edge;
    }

    public void setEdge(Edge edge) {
        this.edge = edge;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        EdgeMaterial that = (EdgeMaterial) o;
        return edgeSide == that.edgeSide &&
                Objects.equals(edge, that.edge);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), edgeSide, edge);
    }
}
