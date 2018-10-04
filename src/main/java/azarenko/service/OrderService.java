package azarenko.service;

import azarenko.entity.Order;

import java.util.List;

public interface OrderService {

    Order getByID(String id);

    List<Order> getAll();

    List<Order> getByAuthor(String firstName);

    List<Order> getByName(String name);

    void save(Order order);

    void delete(String id);
}
