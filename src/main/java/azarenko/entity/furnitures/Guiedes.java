package azarenko.entity.furnitures;

import azarenko.entity.Furniture;

public class Guiedes extends Furniture<Guiedes> {

    private int articul;

    private String nameManufacture;

    private TypeGuide typeLifts;

    private int length;

    private boolean microlift = false;

    public Guiedes() {
    }

    public int getArticul() {
        return articul;
    }

    public void setArticul(int articul) {
        this.articul = articul;
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

    public boolean isMicrolift() {

        return microlift;
    }

    public void setMicrolift(boolean microlift) {
        this.microlift = microlift;
    }


}
