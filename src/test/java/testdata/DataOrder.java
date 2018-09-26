package testdata;

import azarenko.entity.Author;
import azarenko.entity.Order;
import azarenko.entity.OrderTypeChoise;

public class DataOrder {
    public static Order order = new Order(1L,"Камод",new Author("Anton", "Azarenko"),
            OrderTypeChoise.CHEST_OF_DRAWERS, DataModule.getModule(),null,null,null);
}
