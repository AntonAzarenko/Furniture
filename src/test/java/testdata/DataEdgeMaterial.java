package testdata;

import azarenko.entity.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class DataEdgeMaterial {
    public static Set<EdgeMaterial> edgeMaterialSideWall = new HashSet<>();
    public static Set<EdgeMaterial> edgeMaterialCounterTop = new HashSet<>();
    public static Set<EdgeMaterial> edgeMaterialFloor = new HashSet<>();
    public static Set<EdgeMaterial> buttCloseFacade = new HashSet<>();

    static {
        edgeMaterialSideWall.add(new EdgeMaterial(1L, Country.RUSSIA, "Egger", EdgeType.ABC, "pepel",
                new BigDecimal(0.35), 1, ButtClose.BUTT_Y));
        edgeMaterialSideWall.add(new EdgeMaterial(2L, Country.RUSSIA, "noname", EdgeType.MALMIN, "pepel",
                new BigDecimal(0.01), 0.2, ButtClose.BUTT_Y));
        edgeMaterialCounterTop.add(new EdgeMaterial(3L, Country.RUSSIA, "Egger", EdgeType.ABC, "pepel",
                new BigDecimal(1.2), 2, ButtClose.BUTT_ARROUND));
        edgeMaterialFloor.add(new EdgeMaterial(4L, Country.RUSSIA, "Egger", EdgeType.ABC, "pepel",
                new BigDecimal(0.35), 1, ButtClose.BUTT_Y));
        buttCloseFacade.add(new EdgeMaterial(5L, Country.AUSTRIA, "Arpa", EdgeType.PVH, "graphit",
                new BigDecimal(2.3), 2, ButtClose.BUTT_ARROUND));

    }


}