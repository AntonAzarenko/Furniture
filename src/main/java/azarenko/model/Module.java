package azarenko.model;

import java.util.List;
import java.util.Objects;

public class Module {
    private Long orderBy;

    private List<Detail> detailList;

    private List<Furniture> furnitureList;

    private List<Facade> facadeList;

    @Override
    public String toString() {
        return "Module{" +
                "orderBy=" + orderBy +
                ", detailList=" + detailList +
                ", furnitureList=" + furnitureList +
                ", facadeList=" + facadeList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Module module = (Module) o;
        return Objects.equals(orderBy, module.orderBy) &&
                Objects.equals(detailList, module.detailList) &&
                Objects.equals(furnitureList, module.furnitureList) &&
                Objects.equals(facadeList, module.facadeList);
    }

    @Override
    public int hashCode() {

        return Objects.hash(orderBy, detailList, furnitureList, facadeList);
    }

    public Long getOrderBy() {

        return orderBy;
    }

    public void setOrderBy(Long orderBy) {
        this.orderBy = orderBy;
    }

    public List<Detail> getDetailList() {
        return detailList;
    }

    public void setDetailList(List<Detail> detailList) {
        this.detailList = detailList;
    }

    public List<Furniture> getFurnitureList() {
        return furnitureList;
    }

    public void setFurnitureList(List<Furniture> furnitureList) {
        this.furnitureList = furnitureList;
    }

    public List<Facade> getFacadeList() {
        return facadeList;
    }

    public void setFacadeList(List<Facade> facadeList) {
        this.facadeList = facadeList;
    }

    public Module(Long orderBy, List<Detail> detailList, List<Furniture> furnitureList, List<Facade> facadeList) {

        this.orderBy = orderBy;
        this.detailList = detailList;
        this.furnitureList = furnitureList;
        this.facadeList = facadeList;
    }

    public Module() {

    }
}
