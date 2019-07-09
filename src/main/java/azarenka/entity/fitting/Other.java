package azarenka.entity.fitting;

import azarenka.entity.BaseEntity;

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
