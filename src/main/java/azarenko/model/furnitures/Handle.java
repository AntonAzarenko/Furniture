package azarenko.model.furnitures;

import azarenko.model.Furniture;

import java.util.Objects;

public class Handle extends Furniture<Handle> {

    private String articul;

    private HandleColor color;

    private int centerDistance;

    public Handle() {
    }

    public Handle(String articul, HandleColor color, int centerDistance) {
        this.articul = articul;
        this.color = color;
        this.centerDistance = centerDistance;
    }

    public String getArticul() {
        return articul;
    }

    public void setArticul(String articul) {
        this.articul = articul;
    }

    public HandleColor getColor() {
        return color;
    }

    public void setColor(HandleColor color) {
        this.color = color;
    }

    public int getCenterDistance() {
        return centerDistance;
    }

    public void setCenterDistance(int centerDistance) {
        this.centerDistance = centerDistance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Handle handle = (Handle) o;
        return centerDistance == handle.centerDistance &&
                Objects.equals(articul, handle.articul) &&
                color == handle.color;
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), articul, color, centerDistance);
    }

    @Override
    public String toString() {
        return "Handle{" +
                "articul='" + articul + '\'' +
                ", color=" + color +
                ", centerDistance=" + centerDistance +
                '}';
    }
}
