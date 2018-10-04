package azarenko.repository.logic.proxy;

import azarenko.entity.Order;
import azarenko.repository.OrderRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ProxyOrderRepository extends MongoRepository<Order, String> {
    List<Order> getByName(String name);

    @Query(value = "{'Author.firstName' :?0}")
    List<Order> getAllByAuthor(String firstName);

    Order getById(String id);


}
