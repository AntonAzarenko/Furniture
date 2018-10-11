package azarenko.entity.furnitures;

import azarenko.entity.Angle;
import azarenko.entity.Country;
import azarenko.entity.Furniture;

public class Loops extends Furniture<Loops>  {

    private int articul;

    private String nameManufacture;

    private Country manufactureCountry;

    private Angle angle;

    private TypeLoop type;

    private boolean microlift = false;

    public Loops() {
    }

    public Loops(int articul, String nameManufacture, Country manufactureCountry, Angle angle, TypeLoop type, boolean microlift) {
        this.articul = articul;
        this.nameManufacture = nameManufacture;
        this.manufactureCountry = manufactureCountry;
        this.angle = angle;
        this.type = type;
        this.microlift = microlift;
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
    public String toString() {
        return "Loops{" +
                "articul=" + articul +
                ", nameManufacture='" + nameManufacture + '\'' +
                ", manufactureCountry=" + manufactureCountry +
                ", angle=" + angle +
                ", type=" + type +
                ", microlift=" + microlift +
                '}';
    }
}
