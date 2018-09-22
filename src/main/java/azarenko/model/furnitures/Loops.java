package azarenko.model.furnitures;

import azarenko.model.Angle;

import azarenko.model.Country;
import azarenko.model.Furniture;

import java.util.Objects;

public class Loops extends Furniture<Loops>  {

    private String nameManufacture;

    private Country manufactureCountry;

    private Angle angle;

    private TypeLoop type;

    public Loops() {
    }

    public Loops(String nameManufacture, Country manufactureCountry, Angle angle, TypeLoop type) {
        this.nameManufacture = nameManufacture;
        this.manufactureCountry = manufactureCountry;
        this.angle = angle;
        this.type = type;
    }

    public String getNameManufacture() {
        return nameManufacture;
    }

    public void setNameManufacture(String nameManufacture) {
        this.nameManufacture = nameManufacture;
    }

    public Country getManufactureCountry() {
        return manufactureCountry;
    }

    public void setManufactureCountry(Country manufactureCountry) {
        this.manufactureCountry = manufactureCountry;
    }

    public Angle getAngle() {
        return angle;
    }

    public void setAngle(Angle angle) {
        this.angle = angle;
    }

    public TypeLoop getType() {
        return type;
    }

    public void setType(TypeLoop type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Loops loops = (Loops) o;
        return Objects.equals(nameManufacture, loops.nameManufacture) &&
                Objects.equals(manufactureCountry, loops.manufactureCountry) &&
                Objects.equals(angle, loops.angle) &&
                type == loops.type;
    }

    @Override
    public int hashCode() {

        return Objects.hash(nameManufacture, manufactureCountry, angle, type);
    }

    @Override
    public String toString() {
        return "Loops{" +
                "nameManufacture='" + nameManufacture + '\'' +
                ", manufactureCountry='" + manufactureCountry + '\'' +
                ", angle=" + angle +
                ", type=" + type +
                '}';
    }
}
