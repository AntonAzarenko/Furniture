package azarenka.dto;

import azarenka.entity.*;

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

    private Long colorId;

    private EdgeType edgeTypeY;

    private String edgeTypeX;

    private EdgeSide edgeSideX;

    private EdgeSide edgeSideY;

    private Edge colorEdgeX;

    private Edge colorEdgeY;

    private Long moduleId;

    public Detail asDetail() {
        Detail detail = new Detail();
        detail.setId(this.id);
        detail.setName(this.name);
        detail.setX(this.x);
        detail.setY(this.y);
        detail.setCount(this.count);
        detail.setThickness(this.thickness);
        detail.setMaterial(this.material);
        Set<EdgeMaterial> materialSet = new HashSet<>();
        if(colorEdgeX != null){
            materialSet.add(createEdgeMaterialX());
        }
        if(colorEdgeY != null){
            materialSet.add(createEdgeMaterialY());
        }
        detail.setEdgeMaterial(materialSet);
        //todo
        DetailsColor detailsColor = new DetailsColor();
        detailsColor.setId(colorId);
        detail.setDetailsColor(detailsColor);
        detail.setModule(createModule());
        return detail;
    }

    private Module createModule(){
        if (moduleId !=null){
            Module module = new Module();
            module.setId(moduleId);
            return module;
        }
        return null;
    }

    private EdgeMaterial createEdgeMaterialX(){
        EdgeMaterial edgeMaterial = new EdgeMaterial();
        edgeMaterial.setEdgeSide(edgeSideX);
        edgeMaterial.setEdge(colorEdgeX);
        return edgeMaterial;
    }

    private EdgeMaterial createEdgeMaterialY(){
        EdgeMaterial edgeMaterial = new EdgeMaterial();
        edgeMaterial.setEdge(colorEdgeY);
        return edgeMaterial;
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

    public Long getColorId() {
        return colorId;
    }

    public void setColorId(Long colorId) {
        this.colorId = colorId;
    }

    public EdgeType getEdgeTypeY() {
        return edgeTypeY;
    }

    public void setEdgeTypeY(EdgeType edgeTypeY) {
        this.edgeTypeY = edgeTypeY;
    }

    public String getEdgeTypeX() {
        return edgeTypeX;
    }

    public void setEdgeTypeX(String edgeTypeX) {
        this.edgeTypeX = edgeTypeX;
    }

    public EdgeSide getEdgeSideX() {
        return edgeSideX;
    }

    public void setEdgeSideX(EdgeSide edgeSideX) {
        this.edgeSideX = edgeSideX;
    }

    public EdgeSide getEdgeSideY() {
        return edgeSideY;
    }

    public void setEdgeSideY(EdgeSide edgeSideY) {
        this.edgeSideY = edgeSideY;
    }

    public Edge getColorEdgeX() {
        return colorEdgeX;
    }

    public void setColorEdgeX(Edge colorEdgeX) {
        this.colorEdgeX = colorEdgeX;
    }

    public Edge getColorEdgeY() {
        return colorEdgeY;
    }

    public void setColorEdgeY(Edge colorEdgeY) {
        this.colorEdgeY = colorEdgeY;
    }

    public Long getModuleId() {
        return moduleId;
    }

    public void setModuleId(Long moduleId) {
        this.moduleId = moduleId;
    }
}
