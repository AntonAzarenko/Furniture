package azarenka.entity;

import javax.persistence.*;

@Entity
@Table(name = "edge_of_detail_has_side")
public class EdgeMaterial extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(name = "side", nullable = false)
    private EdgeSide edgeSide;

    @OneToOne
    @JoinColumn(name = "edge_id")
    private Edge edge;

    @ManyToOne
    @JoinColumn(name = "detail_id")
    private Detail details;

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

    public Detail getDetails() {
        return details;
    }

    public void setDetails(Detail details) {
        this.details = details;
    }
}
