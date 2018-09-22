package azarenko.mock;

import azarenko.model.Country;
import azarenko.model.EdgeMaterial;

import java.math.BigDecimal;

public  class  DataEdgeMaterial {
    public static EdgeMaterial edgeMaterial = new EdgeMaterial(1L, Country.RUSSIA, "Egger", "pepel", new BigDecimal(0.35));
}
