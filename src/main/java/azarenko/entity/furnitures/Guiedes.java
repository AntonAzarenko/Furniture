package azarenko.entity.furnitures;

import azarenko.entity.Furniture;

import java.util.Objects;

public class Guiedes extends Furniture<Guiedes> {

    private int articul;

    private String nameManufacture;

    private TypeGuide typeLifts;

    private int length;

    private boolean microlift = false;

    public Guiedes() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Guiedes guiedes = (Guiedes) o;
        return articul == guiedes.articul &&
                length == guiedes.length &&
                microlift == guiedes.microlift &&
                Objects.equals(nameManufacture, guiedes.nameManufacture) &&
                typeLifts == guiedes.typeLifts;
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), articul, nameManufacture, typeLifts, length, microlift);
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
