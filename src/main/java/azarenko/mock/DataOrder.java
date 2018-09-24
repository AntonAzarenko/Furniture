package azarenko.mock;

import azarenko.model.Author;
import azarenko.model.Order;
import azarenko.model.OrderTypeChoise;

public class DataOrder {
    public static Order order = new Order(1L,1L,"Камод",new Author("Anton", "Azarenko"),
            OrderTypeChoise.CHEST_OF_DRAWERS, DataModule.getModule(),null,null,null);
}
