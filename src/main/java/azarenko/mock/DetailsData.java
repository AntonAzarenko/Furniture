package azarenko.mock;

import azarenko.model.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DetailsData {
    public static List<Detail> detailList = new ArrayList<>();
    public static Set<ButtClose> buttCloseSetSidewall = new HashSet<>();
    public static Set<ButtClose> buttCloseSetCounterTop = new HashSet<>();
    public static Set<ButtClose> buttCloseSetFloor = new HashSet<>();
    public static Set<ButtClose> buttCloseFacade = new HashSet<>();
    public static Detail detail ;
    public static Color color = new Color(1L, "Аляска", "Swisspan", Country.POLAND);

    static {
        buttCloseSetSidewall.add(ButtClose.BUTT_Y);
        buttCloseSetSidewall.add(ButtClose.BUTT_X);
        buttCloseSetCounterTop.add(ButtClose.BUTT_Y);
        buttCloseSetSidewall.add(ButtClose.BUTT_DOUBLE_X);
        buttCloseSetFloor.add(ButtClose.BUTT_DOUBLE_X);
        buttCloseFacade.add(ButtClose.BUT_ARROUND);


        detailList.add(new Detail(1L, 1L, DataEdgeMaterial.edgeMaterial, "sidewall", 18,
                380, 1000, buttCloseSetSidewall, 2, Material.DSP, color));
        detailList.add(new Detail(2L, 1L, DataEdgeMaterial.edgeMaterial, "counter top", 18,
                410, 1000, buttCloseSetCounterTop, 1, Material.DSP, color));
        detailList.add(new Detail(3L, 1L, DataEdgeMaterial.edgeMaterial, "floor", 18,
                964, 380, buttCloseSetCounterTop, 1, Material.DSP, color));
        detailList.add(new Detail(4L, 1L, null, "back side", 4,
                995, 955, buttCloseSetCounterTop, 1, Material.DVP, null));
        detailList.add(new Detail(5L, 1L, DataEdgeMaterial.edgeMaterial, "socle", 18,
                964, 60, buttCloseSetCounterTop, 1, Material.DSP, color));
        detailList.add(new Detail(6L, 1L, DataEdgeMaterial.edgeMaterial, "shelf", 18,
                963, 360, buttCloseSetCounterTop, 3, Material.DSP, color));
        detail = new Detail(7L, 1L,null, "facade",18, 496,  956, buttCloseFacade,2, Material.DSP, new Color(3L,"white","Arpa",Country.AUSTRIA));

    }

}
