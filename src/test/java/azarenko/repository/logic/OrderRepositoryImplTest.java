package azarenko.repository.logic;

import azarenko.entity.Order;
import azarenko.repository.OrderRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import testdata.DataOrder;

import static testdata.DataOrder.orderTest;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootApplication
public class OrderRepositoryImplTest {

    private final static Logger log = LoggerFactory.getLogger(DetailRepositoryImplTest.class);

    @Autowired
    private OrderRepository repository;

    @Test
    public void getByName() {
        Order order = repository.getByName("Камод");
        log.info(order.toString());
        DataOrder.assertMatch(order, orderTest);


    }

    @Test
    public void getByAuthor() {
    }

    @Test
    public void getByModuleName() {
    }

    @Test
    public void save() {
        repository.save(orderTest);
    }

    @Test
    public void read() {
    }

    @Test
    public void readAll() {
    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {
        Order order = repository.getByName("Камод");
        repository.delete(order.getId());
    }
}