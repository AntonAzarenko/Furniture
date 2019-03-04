package azarenka.entity.furnitures;

import azarenka.entity.stillunused.Fitting;

public class Other extends Fitting<Other> {
    private String name;


    public Other() {
        super();
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

}
