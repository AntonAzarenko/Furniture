package azarenko.entity.furnitures;

import azarenko.entity.Country;
import azarenko.entity.Furniture;

import java.util.Objects;


public class Lifts extends Furniture<Lifts> {
    private int articul;

    private String nameManufacture;

    private Country country;

    private TypeLift lift;

    public Lifts() {
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

    @Override
    public String toString() {
        return "Lifts{" +
                "nameManufacture='" + nameManufacture + '\'' +
                ", country=" + country +
                ", lift=" + lift +
                '}';
    }
}
