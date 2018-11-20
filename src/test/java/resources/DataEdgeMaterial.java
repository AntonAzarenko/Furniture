package resources;

import azarenka.entity.EdgeSide;
import azarenka.entity.Country;
import azarenka.entity.EdgeMaterial;
import azarenka.entity.EdgeType;

import java.math.BigDecimal;
import java.util.*;

public class DataEdgeMaterial {
    public static List<EdgeMaterial> edgeMaterialSideWall = new ArrayList<>();
    public static List<EdgeMaterial> edgeMaterialCounterTop = new ArrayList<>();
    public static List<EdgeMaterial> edgeMaterialFloor = new ArrayList<>();
    public static List<EdgeMaterial> buttCloseFacade = new ArrayList<>();
    public static List<EdgeMaterial> edgeMaterialSocle = new ArrayList<>();

    static {
        edgeMaterialSideWall.add(new EdgeMaterial(null, Country.RUSSIA, "Egger", EdgeType.ABC, "pepel",
                new BigDecimal(0.35), 1, EdgeSide.BUTT_Y));
        edgeMaterialSideWall.add(new EdgeMaterial(null, Country.RUSSIA, "noname", EdgeType.MALMIN, "pepel",
                new BigDecimal(0.01), 0.2, EdgeSide.BUTT_X));
        edgeMaterialCounterTop.add(new EdgeMaterial(null, Country.RUSSIA, "Egger", EdgeType.ABC, "pepel",
                new BigDecimal(1.2), 2, EdgeSide.BUTT_ARROUND));
        edgeMaterialFloor.add(new EdgeMaterial(null, Country.RUSSIA, "Egger", EdgeType.ABC, "pepel",
                new BigDecimal(0.35), 1, EdgeSide.BUTT_Y));
        buttCloseFacade.add(new EdgeMaterial(null, Country.AUSTRIA, "Arpa", EdgeType.PVH, "graphit",
                new BigDecimal(2.3), 2, EdgeSide.BUTT_ARROUND));
        edgeMaterialSocle.add(new EdgeMaterial(null, Country.RUSSIA, "noname", EdgeType.MALMIN, "pepel",
                new BigDecimal(0.01), 0.2, EdgeSide.BUTT_X));
    }


}