package azarenka.dto;

import azarenka.entity.*;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class DetailDTO {

    private Long id;

    private String name;

    private int x;

    private int y;

    private int count;

    private int thickness;

    private Material material;

    private Long colorId;

    private boolean edgeOnX;

    private boolean edgeOnY;

    private EdgeType edgeTypeY;

    private EdgeType edgeTypeX;

    private String edgeSideX;

    private String edgeSideY;

    private Long edgeIdSideX;

    private Long edgeIdSideY;

    private Long moduleId;

    private String colorTitle;

    private DetailsColor detailsColor;

    private Long edgeMaterialIdX;

    private Long edgeMaterialIdY;

    private Module module;

    public DetailDTO() {
    }

    public List<DetailDTO> asDetailDTO(List<Detail> details) {
        List<DetailDTO> detailDTOList = new ArrayList<>();
        for (Detail detail : details) {
            DetailDTO detailDTO = createDetailDTO(detail);
            Set<EdgeMaterial> edgeMaterials = detail.getEdgeMaterial();
            initOtherFields(edgeMaterials, detailDTO);
            detailDTOList.add(detailDTO);
        }
        return detailDTOList;
    }

    public Detail asDetail() {
        Detail detail = createDetail();
        Set<EdgeMaterial> materialSet = new HashSet<>();
        if (this.edgeOnX) {
            EdgeMaterial edgeMaterial = createEdgeMaterial();
            materialSet.add(edgeMaterial);
        }
        if (this.edgeOnY) {
            EdgeMaterial edgeMaterial = createEdgeMaterial();
            materialSet.add(edgeMaterial);
        }
        detail.setEdgeMaterial(materialSet);
        detail.setDetailsColor(createDetailColor());
        detail.setModule(createModule());
        return detail;
    }

    private DetailsColor createDetailColor() {
        DetailsColor detailsColor = new DetailsColor();
        if (material.equals(Material.DVP)) {
            detailsColor.setId(4L);
        } else {
            detailsColor.setId(colorId);
        }
        return detailsColor;
    }


    private DetailDTO createDetailDTO(Detail detail) {
        DetailDTO detailDTO = new DetailDTO();
        detailDTO.setId(detail.getId());
        detailDTO.setName(detail.getName());
        detailDTO.setModuleId(detail.getModule().getId());
        detailDTO.setX(detail.getX());
        detailDTO.setY(detail.getY());
        detailDTO.setCount(detail.getCount());
        detailDTO.setColorId(detail.getDetailsColor().getId());
        detailDTO.setThickness(detail.getThickness());
        detailDTO.setMaterial(detail.getMaterial());
        detailDTO.setColorTitle(detail.getDetailsColor().getTitle());
        Set<EdgeMaterial> edgeMaterialSet = detail.getEdgeMaterial();
        for (EdgeMaterial cur : edgeMaterialSet) {
            if (cur.getId() != null) {
                if (cur.getEdgeSide().equals(EdgeSide.SIDE_X) || cur.getEdgeSide().equals(EdgeSide.SIDE_DOUBLE_X) ||
                        cur.getEdgeSide().equals(EdgeSide.SIDE_DOUBLE_X_AND_Y)) {
                    detailDTO.setEdgeMaterialIdX(cur.getId());
                } else if (cur.getEdgeSide().equals(EdgeSide.SIDE_Y) || cur.getEdgeSide().equals(EdgeSide.SIDE_DOUBLE_Y) ||
                        cur.getEdgeSide().equals(EdgeSide.SIDE_DOUBLE_Y_AND_X)) {
                    detailDTO.setEdgeMaterialIdY(cur.getId());
                }
            } else continue;
        }

        return detailDTO;
    }

    private void initOtherFields(Set<EdgeMaterial> edgeMaterials, DetailDTO detailDTO) {
        if (edgeMaterials != null) {
            for (EdgeMaterial current : edgeMaterials) {
                switch (current.getEdgeSide()) {
                    case SIDE_X:
                        setSideX(current, 1, detailDTO);
                        break;
                    case SIDE_DOUBLE_X:
                        setSideX(current, 2, detailDTO);
                        break;
                    case SIDE_Y:
                        setSideY(current, 1, detailDTO);
                        break;
                    case SIDE_DOUBLE_Y:
                        setSideY(current, 2, detailDTO);
                        break;
                    case SIDE_DOUBLE_X_AND_Y:
                        setSideX(current, 2, detailDTO);
                        setSideY(current, 1, detailDTO);
                        break;
                    case SIDE_X_AND_Y:
                        setSideY(current, 1, detailDTO);
                        setSideX(current, 1, detailDTO);
                        break;
                    case SIDE_DOUBLE_Y_AND_X:
                        setSideY(current, 2, detailDTO);
                        setSideX(current, 1, detailDTO);
                        break;
                    case SIDE_AROUND:
                        setSideX(current, 2, detailDTO);
                        setSideY(current, 2, detailDTO);
                }
            }
        }
    }

    private void setSideY(EdgeMaterial edgeMaterial, int countSide, DetailDTO detailDTO) {
        detailDTO.setEdgeOnY(true);
        detailDTO.setEdgeTypeY(edgeMaterial.getEdge().getEdgeType());
        detailDTO.setEdgeIdSideY(edgeMaterial.getEdge().getId());
        if (countSide == 1) {
            detailDTO.setEdgeSideY("onceSide");
        } else {
            detailDTO.setEdgeSideY("bothSide");
        }
    }

    private void setSideX(EdgeMaterial edgeMaterial, int countSide, DetailDTO detailDTO) {
        detailDTO.setEdgeOnX(true);
        detailDTO.setEdgeIdSideX(edgeMaterial.getEdge().getId());
        detailDTO.setEdgeTypeX(edgeMaterial.getEdge().getEdgeType());
        if (countSide == 1) {
            detailDTO.setEdgeSideX("onceSide");
        } else {
            detailDTO.setEdgeSideX("bothSide");
        }
    }

    private Detail createDetail() {
        Detail detail = new Detail();
        detail.setId(this.id);
        detail.setName(this.name);
        detail.setX(this.x);
        detail.setY(this.y);
        detail.setCount(this.count);
        detail.setThickness(this.thickness);
        detail.setMaterial(this.material);
        return detail;
    }

    private EdgeMaterial createEdgeMaterial() {
        EdgeMaterial edgeMaterial;
        if (this.edgeOnY && !this.edgeOnX) {
            edgeMaterial = createEdgeMaterialY();
        } else if (this.edgeOnX && !this.edgeOnY) {
            edgeMaterial = createEdgeMaterialX();
        } else {
            edgeMaterial = createEdgeMaterialXAndY();
        }
        return edgeMaterial;
    }

    private Module createModule() {
        Module module = new Module();
        if (moduleId == null && this.module != null) {
            module.setId(this.module.getId());
        } else {
            module.setId(moduleId);
        }
        return module;
    }

    private EdgeMaterial createEdgeMaterialX() {
        EdgeMaterial edgeMaterial = new EdgeMaterial();
        if (this.edgeSideX.equals("onceSide")) {
            edgeMaterial.setEdgeSide(EdgeSide.SIDE_X);
        } else {
            edgeMaterial.setEdgeSide(EdgeSide.SIDE_DOUBLE_X);
        }
        edgeMaterial.setEdge(createEdgeX());
        if (edgeMaterialIdX != null) {
            edgeMaterial.setId(edgeIdSideX);
        }
        return edgeMaterial;
    }

    private EdgeMaterial createEdgeMaterialY() {
        EdgeMaterial edgeMaterial = new EdgeMaterial();
        if (this.edgeSideY.equals("onceSide")) {
            edgeMaterial.setEdgeSide(EdgeSide.SIDE_Y);
        } else {
            edgeMaterial.setEdgeSide(EdgeSide.SIDE_DOUBLE_Y);
        }
        edgeMaterial.setEdge(createEdgeY());
        if (edgeMaterialIdY != null) {
            edgeMaterial.setId(edgeIdSideY);
        }
        return edgeMaterial;
    }

    private Edge createEdgeX() {
        Edge edge = new Edge();
        edge.setId(this.edgeIdSideX);
        return edge;
    }

    private Edge createEdgeY() {
        Edge edge = new Edge();
        edge.setId(this.edgeIdSideY);
        return edge;
    }

    private EdgeMaterial createEdgeMaterialXAndY() {
        EdgeMaterial edgeMaterial = new EdgeMaterial();
        if (edgeIdSideY.equals(edgeIdSideX)) {
            if (this.edgeSideY.equals("onceSide") && this.edgeSideX.equals("bothSide")) {
                edgeMaterial.setEdgeSide(EdgeSide.SIDE_DOUBLE_X_AND_Y);
                edgeMaterial.setEdge(createEdgeY());
            } else if (this.edgeSideX.equals("onceSide") && this.edgeSideY.equals("bothSide")) {
                edgeMaterial.setEdgeSide(EdgeSide.SIDE_DOUBLE_Y_AND_X);
                edgeMaterial.setEdge(createEdgeY());
            } else if (this.edgeSideX.equals("onceSide") && this.edgeSideY.equals("onceSide")) {
                edgeMaterial.setEdgeSide(EdgeSide.SIDE_X_AND_Y);
                edgeMaterial.setEdge(createEdgeY());
                return edgeMaterial;
            } else {
                edgeMaterial.setEdgeSide(EdgeSide.SIDE_AROUND);
                edgeMaterial.setEdge(createEdgeY());
            }
        } else {
            this.edgeOnX = false;
            edgeMaterial = createEdgeMaterialX();
            return edgeMaterial;
        }
        return edgeMaterial;
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

    public Long getEdgeMaterialIdY() {
        return edgeMaterialIdY;
    }

    public void setEdgeMaterialIdY(Long edgeMaterialIdY) {
        this.edgeMaterialIdY = edgeMaterialIdY;
    }

    public void setX(int x) {
        this.x = x;

    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Long getEdgeIdSideX() {
        return edgeIdSideX;
    }

    public void setEdgeIdSideX(Long edgeIdSideX) {
        this.edgeIdSideX = edgeIdSideX;
    }

    public String getColorTitle() {
        return colorTitle;
    }

    public void setColorTitle(String colorTitle) {
        this.colorTitle = colorTitle;
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

    public EdgeType getEdgeTypeX() {
        return edgeTypeX;
    }

    public void setEdgeTypeX(EdgeType edgeTypeX) {
        this.edgeTypeX = edgeTypeX;
    }

    public boolean isEdgeOnX() {
        return edgeOnX;
    }

    public void setEdgeOnX(boolean edgeOnX) {
        this.edgeOnX = edgeOnX;
    }

    public boolean isEdgeOnY() {
        return edgeOnY;
    }

    public Long getEdgeIdSideY() {
        return edgeIdSideY;
    }

    public void setEdgeIdSideY(Long edgeIdSideY) {
        this.edgeIdSideY = edgeIdSideY;
    }

    public void setEdgeOnY(boolean edgeOnY) {
        this.edgeOnY = edgeOnY;
    }

    public String getEdgeSideX() {
        return edgeSideX;
    }

    public DetailsColor getDetailsColor() {
        return detailsColor;
    }

    public void setDetailsColor(DetailsColor detailsColor) {
        this.detailsColor = detailsColor;
    }

    public void setEdgeSideX(String edgeSideX) {
        this.edgeSideX = edgeSideX;
    }

    public String getEdgeSideY() {
        return edgeSideY;
    }

    public void setEdgeSideY(String edgeSideY) {
        this.edgeSideY = edgeSideY;
    }

    public Long getModuleId() {
        return moduleId;
    }

    public Long getEdgeMaterialIdX() {
        return edgeMaterialIdX;
    }

    public void setEdgeMaterialIdX(Long edgeMaterialIdX) {
        this.edgeMaterialIdX = edgeMaterialIdX;
    }

    public void setModuleId(Long moduleId) {
        this.moduleId = moduleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        DetailDTO detailDTO = (DetailDTO) o;

        return new EqualsBuilder()
            .append(x, detailDTO.x)
            .append(y, detailDTO.y)
            .append(count, detailDTO.count)
            .append(thickness, detailDTO.thickness)
            .append(edgeOnX, detailDTO.edgeOnX)
            .append(edgeOnY, detailDTO.edgeOnY)
            .append(id, detailDTO.id)
            .append(name, detailDTO.name)
            .append(material, detailDTO.material)
            .append(colorId, detailDTO.colorId)
            .append(edgeTypeY, detailDTO.edgeTypeY)
            .append(edgeTypeX, detailDTO.edgeTypeX)
            .append(edgeSideX, detailDTO.edgeSideX)
            .append(edgeSideY, detailDTO.edgeSideY)
            .append(edgeIdSideX, detailDTO.edgeIdSideX)
            .append(edgeIdSideY, detailDTO.edgeIdSideY)
            .append(moduleId, detailDTO.moduleId)
            .append(colorTitle, detailDTO.colorTitle)
            .append(detailsColor, detailDTO.detailsColor)
            .append(edgeMaterialIdX, detailDTO.edgeMaterialIdX)
            .append(edgeMaterialIdY, detailDTO.edgeMaterialIdY)
            .append(module, detailDTO.module)
            .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
            .append(id)
            .append(name)
            .append(x)
            .append(y)
            .append(count)
            .append(thickness)
            .append(material)
            .append(colorId)
            .append(edgeOnX)
            .append(edgeOnY)
            .append(edgeTypeY)
            .append(edgeTypeX)
            .append(edgeSideX)
            .append(edgeSideY)
            .append(edgeIdSideX)
            .append(edgeIdSideY)
            .append(moduleId)
            .append(colorTitle)
            .append(detailsColor)
            .append(edgeMaterialIdX)
            .append(edgeMaterialIdY)
            .append(module)
            .toHashCode();
    }
}
