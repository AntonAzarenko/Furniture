package azarenko.entity;

import java.math.BigDecimal;
import java.util.Objects;

public class Color extends BaseEntity {
    private String title;

    private String nameManufacture;

    private Country countryManufacture;

    private BigDecimal price;

    public Color() {
    }

    public Color(String title, String nameManufacture, Country countryManufacture, BigDecimal price) {
        this.title = title;
        this.nameManufacture = nameManufacture;
        this.countryManufacture = countryManufacture;
        this.price = price;
    }

    public Color(String id, String title, String nameManufacture, Country countryManufacture, BigDecimal price) {
        super(id);
        this.title = title;
        this.nameManufacture = nameManufacture;
        this.countryManufacture = countryManufacture;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Color)) return false;
        Color color = (Color) o;
        return Objects.equals(title, color.title) &&
                Objects.equals(nameManufacture, color.nameManufacture) &&
                countryManufacture == color.countryManufacture &&
                Objects.equals(price, color.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, nameManufacture, countryManufacture, price);
    }

    @Override
    public String toString() {
        return "Color{" +
                "title='" + title + '\'' +
                ", nameManufacture='" + nameManufacture + '\'' +
                ", countryManufacture=" + countryManufacture +
                ", price=" + price +
                '}';
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNameManufacture() {
        return nameManufacture;
    }

    public void setNameManufacture(String nameManufacture) {
        this.nameManufacture = nameManufacture;
    }

    public Country getCountryManufacture() {
        return countryManufacture;
    }

    public void setCountryManufacture(Country countryManufacture) {
        this.countryManufacture = countryManufacture;
    }
}
