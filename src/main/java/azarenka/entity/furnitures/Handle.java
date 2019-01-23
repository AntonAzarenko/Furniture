package azarenka.entity.furnitures;

import azarenka.entity.stillunused.Fitting;

public class Handle extends Fitting<Handle> {

    private int article;

    private HandleColor color;

    private int centerDistance;

    public Handle() {
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
}
