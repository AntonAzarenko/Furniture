package azarenko.model.furnitures;

import azarenko.model.Country;
import azarenko.model.Furniture;

import java.util.Objects;


public class Lifts extends Furniture<Lifts> {

   private String nameManufactire;

   private Country country;

   private TypeLift lift;

    public Lifts() {
    }

    public String getNameManufactire() {
        return nameManufactire;
    }

    public void setNameManufactire(String nameManufactire) {
        this.nameManufactire = nameManufactire;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lifts lifts = (Lifts) o;
        return Objects.equals(nameManufactire, lifts.nameManufactire) &&
                country == lifts.country &&
                lift == lifts.lift;
    }

    @Override
    public int hashCode() {

        return Objects.hash(nameManufactire, country, lift);
    }

    @Override
    public String toString() {
        return "Lifts{" +
                "nameManufactire='" + nameManufactire + '\'' +
                ", country=" + country +
                ", lift=" + lift +
                '}';
    }
}
