package azarenka.service.logic;

import azarenka.dto.OrderResponse;
import azarenka.entity.Order;
import azarenka.exceptions.ResponseException;
import azarenka.repository.OrderRepository;
import azarenka.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static azarenka.dto.OrderResponse.asOrderDTO;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository repository;

    @Override
    public Order getByID(Long id) {
        return repository.getById(id);
    }

    @Override
    //TODO cache
    public List<OrderResponse> getAllByUserName(String name) {
        List<OrderResponse> orderResponses = new ArrayList<>();
        if (Objects.nonNull(name)) {
            List<Order> orders = repository.getAllByUserName(name);
            if (!orders.isEmpty()) {
                orders.forEach(element -> orderResponses.add(asOrderDTO(element)));
            }
        }
        return orderResponses;
    }

    @Override
    @Transactional
    public Order create(Order order) {
        if (Objects.nonNull(order)) {
            return repository.save(order);
        } else
        throw new ResponseException("Order can not been null");
    }

    @Override
    @Transactional
    public void update(Order order) {
        if (Objects.nonNull(order)) {
            repository.save(order);
        } else
        throw new ResponseException("Order can not been null");
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        if (Objects.nonNull(id)) {
            repository.deleteById(id);
        }
        throw new ResponseException("Order ID can not been null");
    }
}
