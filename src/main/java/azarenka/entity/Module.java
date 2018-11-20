package azarenka.entity;

import javax.persistence.Entity;
import java.util.List;

public class Module extends BaseEntity {
    private String name;

    private List<Detail> detailList;

    private ModuleType moduleType;

    public Module(Long id, String name, List<Detail> detailList) {
        super(id);
        this.name = name;
        this.detailList = detailList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Detail> getDetailList() {
        return detailList;
    }

    public void setDetailList(List<Detail> detailList) {
        this.detailList = detailList;
    }
}
