package azarenka.entity;

import java.math.BigDecimal;

public class PriceForMaterials {

    private Material material;

    private FacadeType facadeType;

    private BigDecimal price;

    public PriceForMaterials() {
    }

    public PriceForMaterials(Material material, FacadeType facadeType, BigDecimal price) {
        this.material = material;
        this.facadeType = facadeType;
        this.price = price;
    }

    @Override
    public String toString() {
        return "PriceForMaterials{" +
                "material=" + material +
                ", facadeType=" + facadeType +
                ", price=" + price +
                '}';
    }



    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public FacadeType getFacadeType() {
        return facadeType;
    }

    public void setFacadeType(FacadeType facadeType) {
        this.facadeType = facadeType;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
