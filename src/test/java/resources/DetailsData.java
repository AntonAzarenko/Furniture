package resources;

import azarenka.entity.ColorDetail;
import azarenka.entity.Country;
import azarenka.entity.Detail;
import azarenka.entity.Material;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class DetailsData {
    public static List<Detail> detailList = new ArrayList<>();

    public static Detail detail;
    public static ColorDetail colorDetail = new ColorDetail(null, "Аляска", "Swisspan", Country.POLAND, new BigDecimal(6));

    static {
        detailList.add(new Detail(null, 1L, DataEdgeMaterial.edgeMaterialSideWall, "sidewall", 18,
                380, 1000, 2, Material.DSP, colorDetail));
        detailList.add(new Detail(null, 1L, DataEdgeMaterial.edgeMaterialCounterTop, " table top", 18,
                410, 1000, 1, Material.DSP, colorDetail));
        detailList.add(new Detail(null, 1L, DataEdgeMaterial.edgeMaterialFloor, "floor", 18,
                964, 380, 1, Material.DSP, colorDetail));
        detailList.add(new Detail(null, 1L, null, "back side", 4, 995, 955,
                1, Material.DVP, new ColorDetail(null, "white", "Dock", Country.RUSSIA, new BigDecimal(4))));
        detailList.add(new Detail(null, 1L, DataEdgeMaterial.edgeMaterialSocle, "socle", 18,
                964, 60, 1, Material.DSP, colorDetail));
        detailList.add(new Detail(null, 1L, DataEdgeMaterial.buttCloseFacade, "shelf", 18,
                963, 360, 3, Material.DSP, colorDetail));
        detail = new Detail(null, 1L, DataEdgeMaterial.buttCloseFacade, "facade", 18, 496, 956, 2, Material.DSP,
                new ColorDetail(null, "white", "Arpa", Country.AUSTRIA, new BigDecimal(45)));
    }

}
