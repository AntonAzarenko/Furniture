package azarenka.entity;

import javax.persistence.*;

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
}
