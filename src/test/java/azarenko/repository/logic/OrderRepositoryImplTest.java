package azarenko.repository.logic;

import azarenko.entity.Order;
import azarenko.repository.OrderRepository;
import azarenko.repository.logic.proxy.ProxyOrderRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import testdata.DataOrder;

import java.util.List;


import static testdata.DataOrder.ORDER_TEST;
import static testdata.DataOrder.ORDER_TEST2;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderRepositoryImplTest  {

    private final static Logger log = LoggerFactory.getLogger(OrderRepositoryImplTest.class);

    @Autowired
    private OrderRepository repository;

    @Test
    public void getByName() {
        Order order = repository.getByName("Камод");
        log.info(order.toString());
        DataOrder.assertMatch(order, ORDER_TEST);
    }

    @Test
    public void getById() {
        Order order = repository.read("5bb4f3602294ff2214d0c659");
        log.info(order.toString());
        DataOrder.assertMatch(order, ORDER_TEST);
    }

    @Test
    public void getByAuthor() {
        List<Order> order = repository.getByAuthor("Anton");
        DataOrder.assertMatch(order, ORDER_TEST, ORDER_TEST2);
    }

    @Test
    public void getByModuleName() {

    }

    @Test
    public void save() {
        repository.save(ORDER_TEST);
        repository.save(ORDER_TEST2);
    }

    @Test
    public void read() {
    }

    @Test
    public void readAll() {

    }

    @Test
    public void update() {
        repository.save(ORDER_TEST2);
    }

    @Autowired
    ProxyOrderRepository proxyOrderRepository;

    @Test()
    public void delete() {
       proxyOrderRepository.deleteAll();
    }

}