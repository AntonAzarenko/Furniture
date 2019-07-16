package azarenka.entity;


import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.util.Set;

/**
 * Detail class.
 *
 * <p>
 * Copyright (C) 2018 Anton_Azarenka@epam.com
 * </p>
 * Date: 7/16/19
 *
 * @author Anton Azarenka
 */
@Entity
@Table(name = "details")
public class Detail extends BaseEntity {

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "detail_has_edge_material",
            joinColumns = @JoinColumn(name = "detail_id"),
            inverseJoinColumns = @JoinColumn(name = "edge_material_id"))
    private Set<EdgeMaterial> edgeMaterial;
    @Column(name = "name")
    private String name;
    @Column(name = "thickness")
    private int thickness;
    @Column(name = "x")
    private int x;
    @Column(name = "y")
    private int y;
    @Column(name = "count")
    private int count;

    @Enumerated(EnumType.STRING)
    @Column(name = "material")
    private Material material;
    @OneToOne
    @JoinColumn(name = "color_detail_id")
    private DetailsColor detailsColor;
    @ManyToOne
    @JoinColumn(name = "module_id", nullable = false)
    private Module module;

    /**
     * Default constructor.
     */
    public Detail() {
    }

    /**
     * Gets dedatil color.
     *
     * @return detail color.
     */
    public DetailsColor getDetailsColor() {
        return detailsColor;
    }

    /**
     * Sets detail color.
     *
     * @param detailsColor detail color.
     */
    public void setDetailsColor(DetailsColor detailsColor) {
        this.detailsColor = detailsColor;
    }

    /**
     * Gets module {@link Module}
     *
     * @return {@link Module}.
     */
    public Module getModule() {
        return module;
    }

    /**
     * Sets module
     *
     * @param module {@link Module}.
     */
    public void setModule(Module module) {
        this.module = module;
    }

    /**
     * Gets material.
     *
     * @return {@link Material}
     */
    public Material getMaterial() {
        return material;
    }

    /**
     * Sets material.
     *
     * @param material {@link Material}
     */
    public void setMaterial(Material material) {
        this.material = material;
    }

    /**
     * Gets name.
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
     * Gets  set of edge material {@link EdgeMaterial}.
     *
     * @return set of edge materal.
     */
    public Set<EdgeMaterial> getEdgeMaterial() {
        return edgeMaterial;
    }

    /**
     * Sets set of edge material {@link EdgeMaterial}
     *
     * @param edgeMaterial edge material.
     */
    public void setEdgeMaterial(Set<EdgeMaterial> edgeMaterial) {
        this.edgeMaterial = edgeMaterial;
    }

    /**
     * Gets thickness
     *
     * @return thickness.
     */
    public int getThickness() {
        return thickness;
    }

    /**
     * Sets thickness.
     *
     * @param thickness thickness.
     */
    public void setThickness(int thickness) {
        this.thickness = thickness;
    }

    /**
     * Gets length of detail on x side.
     *
     * @return length of detail on x side.
     */
    public int getX() {
        return x;
    }

    /**
     * Sets length of detail on x side.
     *
     * @param x length of detail on x side.
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Gets length of detail on y side.
     *
     * @return length of detail on y side.
     */
    public int getY() {
        return y;
    }

    /**
     * Sets length of detail on y side.
     *
     * @param y length of detail on y side.
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Gets count
     *
     * @return count.
     */
    public int getCount() {
        return count;
    }

    /**
     * Sets count.
     *
     * @param count count
     */
    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Detail detail = (Detail) o;

        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(thickness, detail.thickness)
                .append(x, detail.x)
                .append(y, detail.y)
                .append(count, detail.count)
                .append(edgeMaterial, detail.edgeMaterial)
                .append(name, detail.name)
                .append(material, detail.material)
                .append(detailsColor, detail.detailsColor)
                .append(module, detail.module)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .appendSuper(super.hashCode())
                .append(edgeMaterial)
                .append(name)
                .append(thickness)
                .append(x)
                .append(y)
                .append(count)
                .append(material)
                .append(detailsColor)
                .append(module)
                .toHashCode();
    }
}
