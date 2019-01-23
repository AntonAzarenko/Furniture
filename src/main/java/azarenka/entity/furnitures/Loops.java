package azarenka.entity.furnitures;

import azarenka.entity.Country;
import azarenka.entity.stillunused.Angle;
import azarenka.entity.stillunused.Fitting;

public class Loops extends Fitting<Loops> {

    private int article;

    private String nameManufacture;

    private Country manufactureCountry;

    private Angle angle;

    private TypeLoop type;

    private boolean microLift = false;

    public Loops() {
    }

    public int getArticle() {
        return article;
    }

    public void setArticle(int article) {
        this.article = article;
    }

    public boolean isMicroLift() {
        return microLift;
    }

    public void setMicroLift(boolean microLift) {
        this.microLift = microLift;
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

}
