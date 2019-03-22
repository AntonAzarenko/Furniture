package azarenka.dto.fittingdto;

import azarenka.entity.fitting.Loops;
import azarenka.entity.fitting.TypeLoop;
import azarenka.util.CountryFormatterUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class LoopCreateDTO {

    @Autowired
    private CountryFormatterUtil countryUtil;

    private Long id;

    private String manufacturerName;

    private String country;

    private String fileName;

    private String type;

    private String angle;

    private boolean microLift;

    private BigDecimal price;

    private Loops loops;

    public LoopCreateDTO() {
    }

    public Loops asLoops() {
        Loops loop = new Loops();
        loop.setId(id);
        loop.setManufactureName(manufacturerName);
        loop.setFileName(fileName);
        countryUtil = getCountryUtil();
        loop.setManufactureCountry(countryUtil.replaceCountry(country));
        return loop;
    }

    public LoopParams asLoopsParam() {
        LoopParams params = new LoopParams();
        params.setAngle(angle);
        params.setPrice(price);
        params.setMicroLift(microLift);
        params.setTypeLoop(initTypeLoops(type));
        params.setLoops(loops);
        return params;
    }

    private TypeLoop initTypeLoops(String type) {
        switch (type) {
            case "INNER":
                return TypeLoop.INNER;

            case "OVERHEAD":
                return TypeLoop.OVERHEAD;

            case "HALF_OVERHEAD":
                return TypeLoop.HALF_OVERHEAD;

        }
        return null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAngle() {
        return angle;
    }

    public void setAngle(String angle) {
        this.angle = angle;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getType() {
        return type;
    }

    public CountryFormatterUtil getCountryUtil() {
        return new CountryFormatterUtil();
    }

    public void setCountryUtil(CountryFormatterUtil countryUtil) {
        this.countryUtil = countryUtil;
    }

    public void setType(String type) {
        this.type = type;
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

    public Loops getLoops() {
        return loops;
    }

    public void setLoops(Loops loops) {
        this.loops = loops;
    }
}
