package azarenka.entity;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Edge of detatils entity.
 *
 * <p>
 * Copyright (C) 2018 Anton_Azarenka@epam.com
 * </p>
 * Date: 7/16/19
 *
 * @author Anton Azarenka
 */
@Entity
@Table(name = "edge")
public class Edge extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(name = "country")
    private Country manufacturerCountry;
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

    /**
     * Default constructor.
     */
    public Edge() {
    }

    /**
     * Gets manufacturerCountry.
     *
     * @return manufacturerCountry.
     */
    public Country getManufacturerCountry() {
        return manufacturerCountry;
    }

    /**
     * Sets manufacturerCountry.
     *
     * @param manufacturerCountry
     */
    public void setManufacturerCountry(Country manufacturerCountry) {
        this.manufacturerCountry = manufacturerCountry;
    }

    /**
     * Gets name.
     *
     * @return name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets edge type.
     *
     * @return edge type.
     */
    public EdgeType getEdgeType() {
        return edgeType;
    }

    /**
     * Sets edgeType.
     *
     * @param edgeType edgeType.
     */
    public void setEdgeType(EdgeType edgeType) {
        this.edgeType = edgeType;
    }

    /**
     * Gets color.
     *
     * @return color.
     */
    public String getColor() {
        return color;
    }

    /**
     * Sets color.
     *
     * @param color color.
     */
    public void setColor(String color) {
        this.color = color;
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
     * Gets thickness.
     *
     * @return thickness.
     */
    public double getThickness() {
        return thickness;
    }

    /**
     * Sets thickness.
     *
     * @param thickness thickness.
     */
    public void setThickness(double thickness) {
        this.thickness = thickness;
    }
}
