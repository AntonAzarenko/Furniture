package azarenka.dto;

import azarenka.entity.DetailsColor;
import azarenka.entity.Detail;
import azarenka.entity.EdgeMaterial;
import azarenka.entity.Material;

import java.util.HashSet;
import java.util.Set;

public class DetailDto {

    private Long id;

    private String name;

    private int x;

    private int y;

    private int count;

    private int thickness;

    private Material material;

    private Set<Long> edgeId;

    private DetailsColor colorId;

    public Detail asDetail() {
        Detail detail = new Detail();
        detail.setId(this.id);
        detail.setName(this.name);
        detail.setX(this.x);
        detail.setY(this.y);
        detail.setCount(this.count);
        detail.setThickness(this.thickness);
        detail.setMaterial(this.material);
        Set<EdgeMaterial> edgeMaterials = new HashSet<>();
        for(Long current : edgeId){
            EdgeMaterial edgeMaterial = new EdgeMaterial();
            edgeMaterial.setId(current);
            edgeMaterials.add(edgeMaterial);
        }
        detail.setEdgeMaterial(edgeMaterials);
        detail.setDetailsColor(colorId);
        return detail;
    }

    public DetailDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getThickness() {
        return thickness;
    }

    public void setThickness(int thickness) {
        this.thickness = thickness;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public Set<Long> getEdgeId() {
        return edgeId;
    }

    public void setEdgeId(Set<Long> edgeId) {
        this.edgeId = edgeId;
    }

    public DetailsColor getColorId() {
        return colorId;
    }

    public void setColorId(DetailsColor colorId) {
        this.colorId = colorId;
    }
}
