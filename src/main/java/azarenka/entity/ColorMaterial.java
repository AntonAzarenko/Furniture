package azarenka.entity;

import java.math.BigDecimal;

public class ColorMaterial extends BaseEntity {
    private String title;

    private String nameManufacture;

    private Country countryManufacture;

    private BigDecimal price;

    public ColorMaterial() {
    }

    public ColorMaterial(String title, String nameManufacture, Country countryManufacture, BigDecimal price) {
        this.title = title;
        this.nameManufacture = nameManufacture;
        this.countryManufacture = countryManufacture;
        this.price = price;
    }

    public ColorMaterial(String id, String title, String nameManufacture, Country countryManufacture, BigDecimal price) {
        super(id);
        this.title = title;
        this.nameManufacture = nameManufacture;
        this.countryManufacture = countryManufacture;
        this.price = price;
    }

    @Override
    public String toString() {
        return "ColorMaterial{" +
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
