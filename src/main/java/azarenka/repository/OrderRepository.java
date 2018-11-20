package azarenka.repository;

import azarenka.entity.Order;
import azarenka.repository.mybatis.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<String, Order> {
    List<Order> getByName(String name);

    List<Order> getByAuthor(String firstName);

    List<Order> getByModuleName(String name);


}
