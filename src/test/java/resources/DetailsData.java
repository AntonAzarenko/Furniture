package resources;

import azarenka.entity.ColorDetail;
import azarenka.entity.Country;
import azarenka.entity.Detail;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class DetailsData {
    public static List<Detail> detailList = new ArrayList<>();

    public static Detail detail;
    public static ColorDetail colorMaterial = new ColorDetail(null, "Аляска", "Swisspan", Country.POLAND, new BigDecimal(6));

    static {

    }

}
