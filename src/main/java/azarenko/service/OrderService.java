package azarenko.service;

import azarenko.entity.Order;

import java.util.List;

public interface OrderService {
    Order getByID (String id);

    List<Order> getAll();

    List<Order> getByAuthor(String name);

    Order getByName(String name);

}
