package azarenka.entity.furnitures;

import azarenka.entity.stillunused.Furniture;

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
    public String toString() {
        return "Other{" +
                "name='" + name + '\'' +
                '}';
    }
}
