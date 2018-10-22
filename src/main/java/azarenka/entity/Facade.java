package azarenka.entity;

import java.util.Objects;

public class Facade extends BaseEntity {
    private FacadeType facadeType;

    private Detail detail;

    public Detail getDetail() {
        return detail;
    }

    public void setDetail(Detail detail) {
        this.detail = detail;
    }

    public Facade() {
    }

    public Facade(String id, FacadeType facadeType, Detail detail) {
        super(id);
        this.facadeType = facadeType;
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "Facade{" +
                "facadeType=" + facadeType +
                ", detail=" + detail +
                '}';
    }

    public FacadeType getFacadeType() {
        return facadeType;
    }

    public void setFacadeType(FacadeType facadeType) {
        this.facadeType = facadeType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        Facade facade = (Facade) o;
        return facadeType == facade.facadeType &&
                Objects.equals(detail, facade.detail);
    }

    @Override
    public int hashCode() {

        return Objects.hash(facadeType, detail);
    }
}
