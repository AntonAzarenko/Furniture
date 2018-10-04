package azarenko.service.logic;

import azarenko.entity.Order;
import azarenko.repository.OrderRepository;
import azarenko.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository repository;

    @Override
    public Order getByID(String id) {
        return repository.read(id);
    }

    @Override
    public List<Order> getAll() {
        return repository.readAll();
    }

    @Override
    public List<Order> getByAuthor(String firstName) {
        return repository.getByAuthor(firstName);
    }

    @Override
    public List<Order> getByName(String name) {
        return repository.getByName(name);
    }


}
