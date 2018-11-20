package azarenka.service.logic;

import azarenka.entity.Order;
import azarenka.repository.OrderRepository;
import azarenka.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {


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

    @Override
    public void create(Order order) {
        repository.save(order);
    }

    @Override
    public void update(Order order) {
        repository.update(order);
    }

    @Override
    public void delete(String id) {
        repository.delete(id);
    }



}
