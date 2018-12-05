package azarenka.service.logic;

import azarenka.entity.Order;
import azarenka.repository.OrderRepository;
import azarenka.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
