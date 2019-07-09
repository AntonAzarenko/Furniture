package azarenka.repository;

import azarenka.entity.Order;
import org.omg.CORBA.ORB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> getByName(String name);

    Order getById(Long id);

    List<Order> getAllByUserName(String name);

    Order save(Order order);


}
