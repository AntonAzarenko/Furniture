package azarenko.entity;

import com.fasterxml.jackson.databind.ser.Serializers;

import java.util.List;
import java.util.Objects;

public class Module extends BaseEntity {
    private String name;

    private List<Detail> detailList;

    private List<Furniture> furnitureList;

    private List<Facade> facadeList;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Module module = (Module) o;
        return Objects.equals(name, module.name) &&
                Objects.equals(detailList, module.detailList) &&
                Objects.equals(furnitureList, module.furnitureList) &&
                Objects.equals(facadeList, module.facadeList);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, detailList, furnitureList, facadeList);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Module( List<Detail> detailList, List<Furniture> furnitureList, List<Facade> facadeList) {

        this.detailList = detailList;
        this.furnitureList = furnitureList;
        this.facadeList = facadeList;
    }

    public Module() {

    }

    @Override
    public String toString() {
        return "Module{" +
                "name='" + name + '\'' +
                ", detailList=" + detailList +
                ", furnitureList=" + furnitureList +
                ", facadeList=" + facadeList +
                '}';
    }
}
