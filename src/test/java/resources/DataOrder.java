package resources;

import azarenka.entity.Author;
import azarenka.entity.Order;
import azarenka.entity.ModuleType;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class DataOrder {
    public static Order ORDER_TEST = new Order(null,"Камод",new Author(null,"Anton", "Azarenko"),
            ModuleType.CHEST_OF_DRAWERS, null, DetailsData.detailList,null,null);

    public static Order ORDER_TEST2 = new Order(null,"Камод2",new Author(null,"Anton", "Azarenko"),
            ModuleType.CHEST_OF_DRAWERS, DataModule.getModule(),null,null,null);

    public static Order ORDER_TEST3 = new Order(null,"Камод3",new Author(null,"Dzmitry", "Azarenko"),
            ModuleType.CHEST_OF_DRAWERS, null, DetailsData.detailList,null,null);

    public static void assertMatch(Order actual, Order expected) {
        assertThat(actual).isEqualTo(expected);
    }

    public static void assertMatch(Iterable<Order> actual, Iterable<Order> expected) {
        assertThat(actual).isEqualTo(expected);
    }

    public static void assertMatch(Iterable<Order> actual, Order... expected) {
        assertMatch(actual, Arrays.asList(expected));
    }


}
