package azarenka.service.logic;

import azarenka.dto.OrderDTO;
import azarenka.entity.Order;
import azarenka.repository.OrderRepository;
import azarenka.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static azarenka.dto.OrderDTO.asOrderDTO;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository repository;

    @Override
    public Order getByID(Long id) {
        return repository.getById(id);
    }

    @Override
    public List<Order> getAll() {
        return repository.findAll();
    }

    @Override
    public List<OrderDTO> getAllByUserID() {
        List<Order> orders = repository.findAll();
        List<OrderDTO> orderDTOS = new ArrayList<>();
        orders.forEach(o -> orderDTOS.add(asOrderDTO(o)));
        return orderDTOS;
    }

    @Override
    public List<Order> getByName(String name) {
        return repository.getByName(name);
    }

    @Override
    public void create(Order order) {
        repository.save(order);
    }

    @Override
    public void update(Order order) {
        repository.save(order);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
