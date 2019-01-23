package azarenka.entity.furnitures;

import azarenka.entity.stillunused.Fitting;

public class Guides extends Fitting<Guides> {

    private int article;

    private String nameManufacture;

    private TypeGuide typeLifts;

    private int length;

    private boolean microLift = false;

    public Guides() {
    }


    public String getNameManufacture() {
        return nameManufacture;
    }

    public void setNameManufacture(String nameManufacture) {
        this.nameManufacture = nameManufacture;
    }

    public TypeGuide getTypeLifts() {
        return typeLifts;
    }

    public void setTypeLifts(TypeGuide typeLifts) {
        this.typeLifts = typeLifts;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
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
}
