package azarenka.service.logic;

import azarenka.dto.OrderDTO;
import azarenka.entity.Order;
import azarenka.repository.OrderRepository;
import azarenka.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Override //TODO Do i need this method?
    public List<Order> getAll() {
        return repository.findAll();
    }

    @Override
    @Transactional //TODO cache
    public List<OrderDTO> getAllByUserID() {
        List<Order> orders = repository.findAll();
        List<OrderDTO> orderDTOS = new ArrayList<>();
        orders.forEach(o -> orderDTOS.add(asOrderDTO(o)));
        return orderDTOS;
    }

    @Override//TODO Do i need this method?
    public List<Order> getByName(String name) {
        return repository.getByName(name);
    }

    @Override
    @Transactional
    public void create(Order order) {
        repository.save(order);
    }

    @Override
    @Transactional
    public void update(Order order) {
        repository.save(order);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
