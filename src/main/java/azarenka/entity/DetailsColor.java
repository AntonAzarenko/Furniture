package azarenka.entity;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Details color entity.
 *
 * <p>
 * Copyright (C) 2018 Anton_Azarenka@epam.com
 * </p>
 * Date: 7/16/19
 *
 * @author Anton Azarenka
 */
@Entity
@Table(name = "color_detail")
public class DetailsColor extends BaseEntity {

    @Column(name = "title", unique = true, nullable = false)
    private String title;

    @Column(name = "title_manufacturer", nullable = false)
    private String nameManufacturer;

    @Enumerated(EnumType.STRING)
    @Column(name = "country_manufacturer", nullable = false)
    private Country countryManufacturer;

    @Column(name = "price")
    private BigDecimal price;

    /**
     * Default constructor.
     */
    public DetailsColor() {
    }

    /**
     * Constructor.
     *
     * @param id id.
     * @param title title.
     * @param nameManufacturer manufacturer name.
     * @param countryManufacturer namufacturer country.
     * @param price price.
     */
    public DetailsColor(Long id, String title, String nameManufacturer, Country countryManufacturer, BigDecimal price) {
        super(id);
        this.title = title;
        this.nameManufacturer = nameManufacturer;
        this.countryManufacturer = countryManufacturer;
        this.price = price;
    }

    /**
     * Gets price.
     *
     * @return price.
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * Sets price.
     *
     * @param price price.
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * Gets title.
     *
     * @return title.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets title.
     *
     * @param title title.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets title.
     *
     * @return title.
     */
    public String getNameManufacturer() {
        return nameManufacturer;
    }

    /**
     * Sets name of manufacturer.
     *
     * @param nameManufacturer name of manufacturer.
     */
    public void setNameManufacturer(String nameManufacturer) {
        this.nameManufacturer = nameManufacturer;
    }

    /**
     * Gets title.
     *
     * @return title.
     */
    public Country getCountryManufacturer() {
        return countryManufacturer;
    }

    /**
     * Sets country of manufacturer {@link Country}.
     *
     * @param countryManufacturer country of manufacturer.
     */
    public void setCountryManufacturer(Country countryManufacturer) {
        this.countryManufacturer = countryManufacturer;
    }
}
