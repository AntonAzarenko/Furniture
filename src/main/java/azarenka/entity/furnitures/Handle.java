package azarenka.entity.furnitures;

import azarenka.entity.stillunused.Furniture;

public class Handle extends Furniture<Handle> {

    private int articul;

    private HandleColor color;

    private int centerDistance;

    public Handle() {
    }

    public Handle(int articul, HandleColor color, int centerDistance) {
        this.articul = articul;
        this.color = color;
        this.centerDistance = centerDistance;
    }

    public int getArticul() {
        return articul;
    }

    public void setArticul(int articul) {
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
    public String toString() {
        return "Handle{" +
                "articul='" + articul + '\'' +
                ", color=" + color +
                ", centerDistance=" + centerDistance +
                '}';
    }
}
