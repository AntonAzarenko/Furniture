package azarenko.model;

import java.util.List;
import java.util.Objects;

public class Order extends BaseEntity {

    private Long orderBy;

    private String name;

    private Author author;

    private OrderTypeChoise orderTypeChoise;

    private List<Module> moduleList;

    private List<Detail> detailList;

    private List<Furniture> furnitureList;

    private List<Facade> facadeList;

    public Order() {
    }

    public Order(Long id, Long orderBy, String name, Author author, OrderTypeChoise orderTypeChoise, List<Module> moduleList,
                 List<Detail> detailList, List<Furniture> furnitureList, List<Facade> facadeList) {
        super(id);
        this.orderBy = orderBy;
        this.name = name;
        this.author = author;
        this.orderTypeChoise = orderTypeChoise;
        this.moduleList = moduleList;
        this.detailList = detailList;
        this.furnitureList = furnitureList;
        this.facadeList = facadeList;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderBy=" + orderBy +
                ", name='" + name + '\'' +
                ", author=" + author +
                ", orderTypeChoise=" + orderTypeChoise +
                ", moduleList=" + moduleList +
                ", detailList=" + detailList +
                ", furnitureList=" + furnitureList +
                ", facadeList=" + facadeList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(orderBy, order.orderBy) &&
                Objects.equals(name, order.name) &&
                Objects.equals(author, order.author) &&
                orderTypeChoise == order.orderTypeChoise &&
                Objects.equals(moduleList, order.moduleList) &&
                Objects.equals(detailList, order.detailList) &&
                Objects.equals(furnitureList, order.furnitureList) &&
                Objects.equals(facadeList, order.facadeList);
    }

    @Override
    public int hashCode() {

        return Objects.hash(orderBy, name, author, orderTypeChoise, moduleList, detailList, furnitureList, facadeList);
    }

    public Long getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(Long orderBy) {
        this.orderBy = orderBy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public OrderTypeChoise getOrderTypeChoise() {
        return orderTypeChoise;
    }

    public void setOrderTypeChoise(OrderTypeChoise orderTypeChoise) {
        this.orderTypeChoise = orderTypeChoise;
    }

    public List<Module> getModuleList() {
        return moduleList;
    }

    public void setModuleList(List<Module> moduleList) {
        this.moduleList = moduleList;
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
}
