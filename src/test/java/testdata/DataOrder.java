package testdata;

import azarenko.entity.Author;
import azarenko.entity.Detail;
import azarenko.entity.Order;
import azarenko.entity.OrderTypeChoise;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class DataOrder {
    public static Order ORDER_TEST = new Order(null,"Камод",new Author(null,"Anton", "Azarenko"),
            OrderTypeChoise.CHEST_OF_DRAWERS, null, null,null,null);

    public static Order ORDER_TEST2 = new Order(null,"Камод",new Author(null,"Anton", "Azarenko"),
            OrderTypeChoise.CHEST_OF_DRAWERS, DataModule.getModule(),null,null,null);

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
