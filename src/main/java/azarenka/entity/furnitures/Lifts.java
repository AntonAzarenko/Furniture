package azarenka.entity.furnitures;

import azarenka.entity.BaseEntity;
import azarenka.entity.Country;
import azarenka.entity.Fitting;

public class Lifts extends BaseEntity {

    private int article;

    private String nameManufacture;

    private Country country;

    private TypeLift lift;

    public Lifts() {
    }

    public int getArticle() {
        return article;
    }

    public void setArticle(int article) {
        this.article = article;
    }

    public String getNameManufacture() {
        return nameManufacture;
    }

    public void setNameManufacture(String nameManufacture) {
        this.nameManufacture = nameManufacture;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public TypeLift getLift() {
        return lift;
    }

    public void setLift(TypeLift lift) {
        this.lift = lift;
    }
}
