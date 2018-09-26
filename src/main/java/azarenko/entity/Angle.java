package azarenko.entity;

import java.util.Objects;

public class Angle extends BaseEntity {

    private String name;

    private double angle;

    public String getName() {
        return name;
    }

    public Angle() {
    }

    public Angle(Long id, String name, double angle) {
        super(id);
        this.name = name;
        this.angle = angle;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Angle angle1 = (Angle) o;
        return Double.compare(angle1.angle, angle) == 0 &&
                Objects.equals(name, angle1.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, angle);
    }

    @Override
    public String toString() {
        return "Angle{" +
                "name='" + name + '\'' +
                ", angle=" + angle +
                '}';
    }
}
