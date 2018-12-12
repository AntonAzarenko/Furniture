package azarenka.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "edge_material")
public class EdgeMaterial extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(name = "country")
    private Country manufacturer;

    @Column(name = "name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "edge_type")
    private EdgeType edgeType;

    @Column(name = "color_detail")
    private String color;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "thickness")
    private double thickness;

    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "edge_material_has_side",
            joinColumns = @JoinColumn(name = "edge_material_id"))
    @Column(name = "side")
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<EdgeSide> edgeSide;

    public List<Detail> getDetails() {
        return details;
    }

    public void setDetails(List<Detail> details) {
        this.details = details;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Detail> details;

    public EdgeMaterial() {
    }

    public Set<EdgeSide> getEdgeSide() {
        return edgeSide;
    }

    public void setEdgeSide(Set<EdgeSide> edgeSide) {
        this.edgeSide = edgeSide;
    }

    public double getThickness() {
        return thickness;
    }

    public void setThickness(double thickness) {
        this.thickness = thickness;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EdgeType getEdgeType() {
        return edgeType;
    }

    public void setEdgeType(EdgeType edgeType) {
        this.edgeType = edgeType;
    }

    public Country getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Country manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getCountry() {
        return name;
    }

    public void setCountry(String country) {
        this.name = country;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

}
