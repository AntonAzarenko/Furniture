package azarenka.entity.furnitures;

import azarenka.entity.BaseEntity;
import azarenka.entity.Fitting;

public class Other extends BaseEntity {
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
