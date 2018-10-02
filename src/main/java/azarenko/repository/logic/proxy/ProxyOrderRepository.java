package azarenko.repository.logic.proxy;

import azarenko.entity.Order;
import azarenko.repository.OrderRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ProxyOrderRepository extends MongoRepository<Order, String> {
    Order getByName(String name);

    List<Order> getAllByAuthor(String authorName);


    Order getById(String id);


}
