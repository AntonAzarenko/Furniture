package testdata;

import azarenko.entity.Facade;
import azarenko.entity.FacadeType;

public class DataFacade {
    public static Facade facade = new Facade(1L, FacadeType.PLASTIC, DetailsData.detail);
}
