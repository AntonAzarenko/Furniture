package azarenko.repository;

import azarenko.entity.Order;
import azarenko.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<String, Order> {
    Order getByName(String name);

    List<Order> getByAuthor(String firstName, String lastName);


}
