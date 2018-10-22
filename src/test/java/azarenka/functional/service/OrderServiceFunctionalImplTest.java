package azarenka.functional.service;

import azarenka.entity.Author;
import azarenka.entity.Order;
import azarenka.service.OrderService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.test.context.junit4.SpringRunner;
import resources.DataOrder;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceFunctionalImplTest {

    @Autowired
    private OrderService service;

    @Before
    public void before() {
        service.create(DataOrder.ORDER_TEST);
        service.create(DataOrder.ORDER_TEST2);
    }

    @After
    public void after() {
        String id = service.getByName("Камод").get(0).getId();
        service.delete(id);
        String id2 = service.getByName("Камод2").get(0).getId();
        service.delete(id2);
    }

    @Test
    public void getByID() {
        String id = service.getByName("Камод").get(0).getId();
        Order order = service.getByID(id);
        assertThat(order).isEqualTo(DataOrder.ORDER_TEST);
    }

    @Test
    public void getAll() {
        List<Order> list = service.getAll();
        assertThat(list).isEqualTo(Arrays.asList(DataOrder.ORDER_TEST, DataOrder.ORDER_TEST2));
    }

    @Test
    public void getByAuthor() {
        List<Order> list = service.getByAuthor("Anton");
        assertThat(list).isEqualTo(Arrays.asList(DataOrder.ORDER_TEST, DataOrder.ORDER_TEST2));
    }

    @Test
    public void getByName() {
        List<Order> list = service.getByName("Камод");
        assertThat(list).isEqualTo(Collections.singletonList(DataOrder.ORDER_TEST));
    }

    @Test
    public void create() {
        service.create(DataOrder.ORDER_TEST3);
        List<Order> list = service.getAll();
        assertThat(list.size()).isEqualTo(3);
    }

    @Test
    public void update() {
        Author author = new Author("Volga", "Azarenka");
        Order order = DataOrder.ORDER_TEST;
        order.setAuthor(author);
        service.update(order);
        List<Order> list = service.getByAuthor("Volga");
        assertThat(list.size()).isEqualTo(1);
    }

    @Test
    public void delete() {
        String id = service.getByName("Камод3").get(0).getId();
        service.delete(id);
        List<Order> list = service.getAll();
        assertThat(list.size()).isEqualTo(2);
    }
}
