package testdata;

import azarenko.entity.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class DataEdgeMaterial {
    public static Set<EdgeMaterial> edgeMaterialSideWall = new LinkedHashSet<>();
    public static Set<EdgeMaterial> edgeMaterialCounterTop = new LinkedHashSet<>();
    public static Set<EdgeMaterial> edgeMaterialFloor = new LinkedHashSet<>();
    public static Set<EdgeMaterial> buttCloseFacade = new LinkedHashSet<>();

    static {
        edgeMaterialSideWall.add(new EdgeMaterial(null, Country.RUSSIA, "Egger", EdgeType.ABC, "pepel",
                new BigDecimal(0.35), 1, ButtClose.BUTT_Y));
        edgeMaterialSideWall.add(new EdgeMaterial(null, Country.RUSSIA, "noname", EdgeType.MALMIN, "pepel",
                new BigDecimal(0.01), 0.2, ButtClose.BUTT_Y));
        edgeMaterialCounterTop.add(new EdgeMaterial(null, Country.RUSSIA, "Egger", EdgeType.ABC, "pepel",
                new BigDecimal(1.2), 2, ButtClose.BUTT_ARROUND));
        edgeMaterialFloor.add(new EdgeMaterial(null, Country.RUSSIA, "Egger", EdgeType.ABC, "pepel",
                new BigDecimal(0.35), 1, ButtClose.BUTT_Y));
        buttCloseFacade.add(new EdgeMaterial(null, Country.AUSTRIA, "Arpa", EdgeType.PVH, "graphit",
                new BigDecimal(2.3), 2, ButtClose.BUTT_ARROUND));

    }


}