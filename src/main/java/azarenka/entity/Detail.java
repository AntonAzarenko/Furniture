package azarenka.entity;


import javax.persistence.*;
import java.util.Set;

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

    public DetailsColor getDetailsColor() {
        return detailsColor;
    }

    public void setDetailsColor(DetailsColor detailsColor) {
        this.detailsColor = detailsColor;
    }

    public Detail() {
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<EdgeMaterial> getEdgeMaterial() {
        return edgeMaterial;
    }

    public void setEdgeMaterial(Set<EdgeMaterial> edgeMaterial) {
        this.edgeMaterial = edgeMaterial;
    }

    public int getThickness() {
        return thickness;
    }

    public void setThickness(int thickness) {
        this.thickness = thickness;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
