package testdata;

import azarenko.entity.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public class DetailsData {
    public static List<Detail> detailList = new ArrayList<>();

    public static Detail detail;
    public static ColorMaterial colorMaterial = new ColorMaterial(null, "Аляска", "Swisspan", Country.POLAND, new BigDecimal(6));

    static {
        detailList.add(new Detail(null, 1L, DataEdgeMaterial.edgeMaterialSideWall, "sidewall", 18,
                380, 1000, 2, Material.DSP, colorMaterial));
       /* detailList.add(new Detail(null, 1L, DataEdgeMaterial.edgeMaterialCounterTop, " table top", 18,
                410, 1000, 1, Material.DSP, colorMaterial));
        detailList.add(new Detail(null, 1L, DataEdgeMaterial.edgeMaterialFloor, "floor", 18,
                964, 380, 1, Material.DSP, colorMaterial));
        detailList.add(new Detail(null, 1L, null, "back side", 4, 995, 955,
                1, Material.DVP, null));
        detailList.add(new Detail(null, 1L, DataEdgeMaterial.edgeMaterialSideWall, "socle", 18,
                964, 60, 1, Material.DSP, colorMaterial));
        detailList.add(new Detail(null, 1L, DataEdgeMaterial.buttCloseFacade, "shelf", 18,
                963, 360, 3, Material.DSP, colorMaterial));
        detail = new Detail(null, 1L, DataEdgeMaterial.buttCloseFacade, "facade", 18, 496, 956, 2, Material.DSP,
                new ColorMaterial(null, "white", "Arpa", Country.AUSTRIA, new BigDecimal(45)));*/
    }

}
