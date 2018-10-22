package azarenka.repository;

import azarenka.entity.Order;

import java.util.List;

public interface OrderRepository extends CrudRepository<String, Order> {
    List<Order> getByName(String name);

    List<Order> getByAuthor(String firstName);

    List<Order> getByModuleName(String name);


}