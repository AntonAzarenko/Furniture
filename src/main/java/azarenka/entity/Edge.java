package azarenka.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "edge")
public class Edge extends BaseEntity {

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

    public Edge() {
    }

    public Country getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Country manufacturer) {
        this.manufacturer = manufacturer;
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

    public double getThickness() {
        return thickness;
    }

    public void setThickness(double thickness) {
        this.thickness = thickness;
    }
}
