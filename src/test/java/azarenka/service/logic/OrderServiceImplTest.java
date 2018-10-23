package azarenka.service.logic;

import azarenka.entity.Order;
import azarenka.repository.OrderRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import resources.DataOrder;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class OrderServiceImplTest {

    @InjectMocks
    private OrderServiceImpl service;

    @Mock
    private OrderRepository repository;

    @Test
    public void getByID() {
        when(repository.read(anyString())).thenReturn(DataOrder.ORDER_TEST);
        Order orders = service.getByID(anyString());
        assertThat(orders).isEqualTo(DataOrder.ORDER_TEST);
        verify(repository).read(anyString());
    }

    @Test
    public void getAll() {
        when(repository.readAll()).thenReturn(Collections.singletonList(DataOrder.ORDER_TEST));
        List<Order> orders = service.getAll();
        assertThat(orders).isEqualTo(Collections.singletonList(DataOrder.ORDER_TEST));
        verify(repository).readAll();
    }

    @Test
    public void getByAuthor() {
        when(repository.readAll()).thenReturn(Collections.singletonList(DataOrder.ORDER_TEST));
        List<Order> orders = service.getAll();
        assertThat(orders).isEqualTo(Collections.singletonList(DataOrder.ORDER_TEST));
        verify(repository).readAll();
    }

    @Test
    public void getByName() {
        when(repository.getByName(anyString())).thenReturn(Collections.singletonList(DataOrder.ORDER_TEST));
        List<Order> order = service.getByName(anyString());
        assertThat(order.get(0)).isEqualTo(DataOrder.ORDER_TEST);
        verify(repository).getByName(anyString());
    }

    @Test
    public void save() {
        service.create(DataOrder.ORDER_TEST);
        verify(repository).save(DataOrder.ORDER_TEST);
    }

    @Test
    public void update() {
        service.update(DataOrder.ORDER_TEST);
        verify(repository).update(DataOrder.ORDER_TEST);
    }

    @Test
    public void delete() {
        service.delete(anyString());
        verify(repository).delete(anyString());
    }
}
