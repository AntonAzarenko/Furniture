package azarenka.service.logic;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

import azarenka.dto.OrderResponse;
import azarenka.entity.Order;
import azarenka.exceptions.ResponseException;
import azarenka.repository.OrderRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceImplTest {

    @InjectMocks
    private OrderServiceImpl service;
    @Mock
    private OrderRepository repository;

    @Test
    public void getByID() {
        when(repository.getById(1L)).thenReturn(buildOrder());
        assertEquals(buildOrder(), service.getByID(1L));
        verify(repository).getById(1L);
    }

    @Test
    public void getAllByUserName() {
        when(repository.getAllByUserName("Name")).thenReturn(Arrays.asList(buildOrder(), buildOrder()));
        assertEquals(Arrays.asList(buildOrderDTO(), buildOrderDTO()), service.getAllByUserName("Name"));
        verify(repository).getAllByUserName("Name");
    }

    @Test
    public void create() {
        Order order = buildOrder();
        when(repository.save(order)).thenReturn(order);
        assertEquals(order, service.create(order));
    }

    @Test(expected = ResponseException.class)
    public void createOrderIfOrderNull() {
        Order order = null;
        service.create(order);
    }

    @Test
    public void update() {
        when(repository.save(buildOrder())).thenReturn(buildOrder());
        service.update(buildOrder());
    }

    @Test(expected = ResponseException.class)
    public void updateIfOrderNull() {
        Order order = null;
        service.update(order);
    }

    @Test
    public void deleteById() {
        doNothing().when(repository).deleteById(1L);
        service.deleteById(1L);
        verify(repository).deleteById(1L);
    }

    @Test(expected = ResponseException.class)
    public void deleteByIdIfIdNull() {
        service.deleteById(null);
    }

    private Order buildOrder() {
        Order order = new Order();
        order.setName("Dresses");
        order.setAddress("BELARUS");
        order.setCustomersName("Pavel");
        return order;
    }

    private OrderResponse buildOrderDTO(){
        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setAddress("BELARUS");
        orderResponse.setCustomersName("Pavel");
        orderResponse.setName("Dresses");
        return orderResponse;
    }
}