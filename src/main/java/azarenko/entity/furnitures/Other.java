package azarenko.entity.furnitures;

import azarenko.entity.Furniture;

import java.util.Objects;

public class Other extends Furniture<Other> {
    private String name;


    public Other() {
    }

    public Other(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Other other = (Other) o;
        return Objects.equals(name, other.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Other{" +
                "name='" + name + '\'' +
                '}';
    }
}
