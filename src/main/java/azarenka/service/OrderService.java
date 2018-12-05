package azarenka.service;

import azarenka.entity.Order;

import java.util.List;

public interface OrderService {

    Order getByID(Long id);

    List<Order> getAll();

    List<Order> getByName(String name);

    void create(Order order);

    void update(Order order);

    void deleteById(Long id);
}
