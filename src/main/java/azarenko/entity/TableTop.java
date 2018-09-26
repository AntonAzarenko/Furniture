package azarenko.entity;

import java.math.BigDecimal;
import java.util.Objects;

//столешница
public class TableTop extends BaseEntity {

    private String name;

    private String country;

    private String color;

    private BigDecimal price;

    public TableTop() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TableTop that = (TableTop) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(country, that.country) &&
                Objects.equals(color, that.color) &&
                Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, country, color, price);
    }

    @Override
    public String toString() {
        return "TableTop{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                '}';
    }
}
