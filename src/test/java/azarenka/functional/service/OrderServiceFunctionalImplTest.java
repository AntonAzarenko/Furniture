package azarenka.functional.service;

import azarenka.entity.Order;
import azarenka.service.OrderService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.test.context.junit4.SpringRunner;
import resources.DataOrder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceFunctionalImplTest {

    private final static Logger log = LoggerFactory.getLogger(ColorDetailServiceImplTest.class);

    @Autowired
    private OrderService service;

    @Before
    public void before() {
        service.create(DataOrder.ORDER_TEST);
        service.create(DataOrder.ORDER_TEST2);
    }

    @After
    public void after() {
       List<Order> list = service.getAll();
       List<String> listId = new ArrayList<>();
       list.forEach(order -> listId.add(order.getId()));
       listId.forEach(id -> service.delete(id));
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
        assertThat(list).isEqualTo(Arrays.asList(DataOrder.ORDER_TEST, DataOrder.ORDER_TEST2)); // TODO test failed with the ComparisonFailure
    }

    @Test
    public void getByAuthor() {
        List<Order> list = service.getByAuthor("Anton");
        assertThat(list).isEqualTo(Arrays.asList(DataOrder.ORDER_TEST, DataOrder.ORDER_TEST2));
    }

    @Test
    public void getByAuthorIsNull() {
        List<Order> listIsEmpty = new ArrayList<>();
        List<Order> list = service.getByAuthor(null);
        assertThat(list).isEqualTo(listIsEmpty);
    }

    @Test
    public void getByAuthorIsEmpty() {
        List<Order> list = service.getByAuthor("");
        List<Order> listIsEmpty = new ArrayList<>();
        assertThat(list).isEqualTo(listIsEmpty);
    }

    @Test
    public void getByName() {
        List<Order> list = service.getByName("Камод");
        assertThat(list).isEqualTo(Collections.singletonList(DataOrder.ORDER_TEST));
    }

    @Test
    public void getByNameIsNull() {
        List<Order> listIsEmpty = new ArrayList<>();
        List<Order> list = service.getByName(null);
        assertThat(list).isEqualTo(listIsEmpty);
    }

    @Test
    public void getByNameisEmpty() {
        List<Order> listIsEmpty = new ArrayList<>();
        List<Order> list = service.getByName("");
        assertThat(list).isEqualTo(listIsEmpty);
    }

    @Test
    public void create() {
        service.create(DataOrder.ORDER_TEST3);
        List<Order> list = service.getAll();
        assertThat(list.size()).isEqualTo(3);
    }

    @Test
    public void update() {
        Order order = DataOrder.ORDER_TEST3;
        order.setName("Volga");
        service.update(order);
        List<Order> list = service.getByName("Volga");
        assertThat(list.size()).isEqualTo(1);
    }

    @Test
    public void delete() {
        String id = service.getByName("Камод").get(0).getId();
        log.info(id);
        service.delete(id);
        List<Order> list = service.getAll();
        assertThat(list.size()).isEqualTo(1);
    }
}
