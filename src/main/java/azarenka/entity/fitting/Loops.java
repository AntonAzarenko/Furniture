package azarenka.entity.fitting;

import azarenka.entity.BaseEntity;
import azarenka.entity.Country;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "loops")
public class Loops extends BaseEntity {

    @Column(name = "manufacture_name")
    private String manufactureName;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "country")
    private Country manufactureCountry;

    @Column(name = "angle")
    private String angle;

    @Column(name = "type_loop")
    private TypeLoop typeLoop;

    @Column(name = "micro_Lift")
    private boolean microLift;

    @Column(name = "price")
    private BigDecimal price;

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

    public String getAngle() {
        return angle;
    }

    public void setAngle(String angle) {
        this.angle = angle;
    }

    public TypeLoop getTypeLoop() {
        return typeLoop;
    }

    public void setTypeLoop(TypeLoop typeLoop) {
        this.typeLoop = typeLoop;
    }

    public boolean isMicroLift() {
        return microLift;
    }

    public void setMicroLift(boolean microLift) {
        this.microLift = microLift;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
