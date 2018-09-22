package azarenko.mock;

import azarenko.model.Facade;
import azarenko.model.FacadeType;

public class DataFacade {
    public static Facade facade = new Facade(1L, FacadeType.PLASTIC, DetailsData.detail);
}
