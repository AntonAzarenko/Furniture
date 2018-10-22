package azarenka.repository.logic.proxy;

import azarenka.entity.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ProxyOrderRepository extends MongoRepository<Order, String> {
    List<Order> getByName(String name);

    @Query(value = "{'Author.firstName' :?0}")
    List<Order> getAllByAuthor(String firstName);

    Order getById(String id);


}
