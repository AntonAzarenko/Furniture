package azarenka.entity.fitting;

import azarenka.entity.BaseEntity;
import azarenka.entity.Country;
import azarenka.entity.fitting.params.LoopParams;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "loops")
public class Loops extends BaseEntity {

    @Column(name = "manufacture_name")
    private String manufactureName;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "country")
    private Country manufactureCountry;

    @OneToMany(fetch = FetchType.LAZY)
    private List<LoopParams> params;

    public Loops() {
    }

    public String getManufactureName() {
        return manufactureName;
    }

    public void setManufactureName(String manufactureName) {
        this.manufactureName = manufactureName;
    }

    public Country getManufactureCountry() {
        return manufactureCountry;
    }

    public void setManufactureCountry(Country manufactureCountry) {
        this.manufactureCountry = manufactureCountry;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public List<LoopParams> getParams() {
        return params;
    }

    public void setParams(List<LoopParams> params) {
        this.params = params;
    }
}
