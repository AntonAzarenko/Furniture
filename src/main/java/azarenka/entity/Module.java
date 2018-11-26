package azarenka.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "module")
public class Module extends BaseEntity {
    @Column(name = "title")
    private String name;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Detail> detailList;

    @Enumerated(EnumType.STRING)
    @Column(name = "module_type")
    private ModuleType moduleType;

    public Module() {
    }

    public Module(Long id, String name, List<Detail> detailList, ModuleType moduleType) {
        super(id);
        this.name = name;
        this.detailList = detailList;
        this.moduleType = moduleType;
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

    public ModuleType getModuleType() {
        return moduleType;
    }

    public void setModuleType(ModuleType moduleType) {
        this.moduleType = moduleType;
    }
}
