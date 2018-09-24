package azarenko.mock;

import azarenko.model.Country;
import azarenko.model.EdgeMaterial;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public  class  DataEdgeMaterial {
    public static Set<EdgeMaterial> edgeMaterial = new HashSet<EdgeMaterial>(){
        EdgeMaterial edgeMaterial = new EdgeMaterial(1L, Country.RUSSIA, "Egger", "pepel", new BigDecimal(0.35));
    };


}