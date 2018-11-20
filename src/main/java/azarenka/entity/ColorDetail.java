package azarenka.entity;


import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "color_detail")
public class ColorDetail extends BaseEntity {

    @Column(name = "title", unique = true, nullable = false)
    private String title;

    @Column(name = "title_manufacturer", nullable = false)
    private String nameManufacturer;

    @Enumerated(EnumType.STRING)
    @Column(name = "country_manufacturer", nullable = false)
    private Country countryManufacturer;

    @Column(name = "price")
    private BigDecimal price;

    public ColorDetail() {
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

    public String getNameManufacturer() {
        return nameManufacturer;
    }

    public void setNameManufacturer(String nameManufacturer) {
        this.nameManufacturer = nameManufacturer;
    }

    public Country getCountryManufacturer() {
        return countryManufacturer;
    }

    public void setCountryManufacturer(Country countryManufacturer) {
        this.countryManufacturer = countryManufacturer;
    }
}
