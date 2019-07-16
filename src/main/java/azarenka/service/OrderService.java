package azarenka.service;

import azarenka.dto.OrderResponse;
import azarenka.entity.Order;

import java.util.List;

public interface OrderService {

    Order getByID(Long id);

    Order create(Order order);

    void update(Order order);

    void deleteById(Long id);

    List<OrderResponse> getAllByUserName(String name);
}
