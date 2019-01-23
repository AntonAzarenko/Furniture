package azarenka.entity;

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

    public Facade(Long id, FacadeType facadeType, Detail detail) {
        super(id);
        this.facadeType = facadeType;
        this.detail = detail;
    }

    public FacadeType getFacadeType() {
        return facadeType;
    }

    public void setFacadeType(FacadeType facadeType) {
        this.facadeType = facadeType;
    }
}
