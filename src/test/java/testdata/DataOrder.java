package testdata;

import azarenko.entity.Author;
import azarenko.entity.Detail;
import azarenko.entity.Order;
import azarenko.entity.OrderTypeChoise;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class DataOrder {
    public static Order orderTest = new Order(null,"Камод",new Author("Anton", "Azarenko"),
            OrderTypeChoise.CHEST_OF_DRAWERS, DataModule.getModule(),null,null,null);

   /* public static void assertMatch(Order actual, Order expected) {
        assertThat(actual).isEqualToIgnoringGivenFields(expected, "id");
    }*/

    /*public static void assertMatch(Iterable<Order> actual, Iterable<Order> expected) {
        assertThat(actual).isEqualTo(expected);
    }*/

   /* public static void assertMatch(Iterable<Order> actual, Order... expected) {
        assertMatch(actual, Arrays.asList(expected));
    }*/

    public static void assertMatch(Detail actual, Detail expected) {
        assertThat(actual).isEqualToIgnoringGivenFields(expected, "id");
    }

    public static void assertMatch(Iterable<Detail> actual, Iterable<Detail> expected) {
        assertThat(actual).isEqualTo(expected);
    }

    public static void assertMatch(Iterable<Detail> actual, Detail... expected) {
        assertMatch(actual, Arrays.asList(expected));
    }
}
