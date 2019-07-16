package azarenka.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

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
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        EdgeMaterial that = (EdgeMaterial) o;

        return new EqualsBuilder()
            .appendSuper(super.equals(o))
            .append(edgeSide, that.edgeSide)
            .append(edge, that.edge)
            .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
            .appendSuper(super.hashCode())
            .append(edgeSide)
            .append(edge)
            .toHashCode();
    }
}
