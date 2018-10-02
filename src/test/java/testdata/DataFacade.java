package testdata;

import azarenko.entity.Facade;
import azarenko.entity.FacadeType;

public class DataFacade {
    public static Facade facade = new Facade(null, FacadeType.PLASTIC, DetailsData.detail);
}
