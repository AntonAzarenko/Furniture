package azarenko.entity;

import java.math.BigDecimal;
import java.util.Objects;

public class EdgeMaterial extends BaseEntity {

    private Country manufacturer;

    private String name;

    private EdgeType edgeType;

    private String color;

    private BigDecimal price;

    private double thickness;

    //по каким сторонам кромим
    private ButtClose buttCloses;

    public EdgeMaterial() {
    }

    public EdgeMaterial(Country manufacturer, String name, EdgeType edgeType, String color, BigDecimal price, double thickness, ButtClose buttCloses) {
        this.manufacturer = manufacturer;
        this.name = name;
        this.edgeType = edgeType;
        this.color = color;
        this.price = price;
        this.thickness = thickness;
        this.buttCloses = buttCloses;
    }

    public EdgeMaterial(String id, Country manufacturer, String name, EdgeType edgeType, String color, BigDecimal price,
                        double thickness, ButtClose buttCloses) {
        super(id);
        this.manufacturer = manufacturer;
        this.name = name;
        this.edgeType = edgeType;
        this.color = color;
        this.price = price;
        this.thickness = thickness;
        this.buttCloses = buttCloses;
    }

    public double getThickness() {
        return thickness;
    }

    public void setThickness(double thickness) {
        this.thickness = thickness;
    }

    public ButtClose getButtCloses() {
        return buttCloses;
    }

    public void setButtCloses(ButtClose buttCloses) {
        this.buttCloses = buttCloses;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EdgeMaterial that = (EdgeMaterial) o;
        return manufacturer == that.manufacturer &&
                Objects.equals(name, that.name) &&
                edgeType == that.edgeType &&
                Objects.equals(color, that.color) &&
                Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {

        return Objects.hash(manufacturer, name, edgeType, color, price);
    }

    @Override
    public String toString() {
        return "EdgeMaterial{" +
                "manufacturer=" + manufacturer +
                ", name='" + name + '\'' +
                ", edgeType=" + edgeType +
                ", color='" + color + '\'' +
                ", price=" + price +
                '}';
    }
}
