package azarenko.model.furnitures;

import azarenko.model.Furniture;

public class Guiedes extends Furniture<Guiedes> {
    private String nameManufacture;

    private TypeGuide typeLifts;

    private int length;

    public Guiedes() {
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

    private boolean microlift = false;
}
