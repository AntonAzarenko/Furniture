package azarenka.service;

import azarenka.dto.OrderDTO;
import azarenka.entity.Order;

import java.util.List;

public interface OrderService {

    Order getByID(Long id);

    void create(Order order);

    void update(Order order);

    void deleteById(Long id);

    List<OrderDTO> getAllByUserName(String name);
}
