package testdata;

import azarenko.entity.*;

import java.util.ArrayList;
import java.util.List;


public class DetailsData {
    public static List<Detail> detailList = new ArrayList<>();

    public static Detail detail;
    public static Color color = new Color(1L, "Аляска", "Swisspan", Country.POLAND);

    static {


        detailList.add(new Detail(1L, 1L, DataEdgeMaterial.edgeMaterialSideWall, "sidewall", 18,
                380, 1000, 2, Material.DSP, color));
        detailList.add(new Detail(2L, 1L, DataEdgeMaterial.edgeMaterialCounterTop, " table top", 18,
                410, 1000, 1, Material.DSP, color));
        detailList.add(new Detail(3L, 1L, DataEdgeMaterial.edgeMaterialFloor, "floor", 18,
                964, 380, 1, Material.DSP, color));
        detailList.add(new Detail(4L, 1L, null, "back side", 4,
                995, 955, 1, Material.DVP, null));
        detailList.add(new Detail(5L, 1L, DataEdgeMaterial.edgeMaterialSideWall, "socle", 18,
                964, 60, 1, Material.DSP, color));
        detailList.add(new Detail(6L, 1L, DataEdgeMaterial.buttCloseFacade, "shelf", 18,
                963, 360, 3, Material.DSP, color));
        detail = new Detail(7L, 1L, DataEdgeMaterial.buttCloseFacade, "facade", 18, 496, 956, 2, Material.DSP,
                new Color(3L, "white", "Arpa", Country.AUSTRIA));

    }

}
