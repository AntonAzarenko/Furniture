package azarenko.repository.logic;

import azarenko.entity.Order;
import azarenko.repository.OrderRepository;
import azarenko.repository.logic.proxy.ProxyOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderRepositoryImpl implements OrderRepository {
    @Autowired
    private ProxyOrderRepository proxy;

    @Override
    public Order getByName(String name) {
        return proxy.getByName(name);
    }

    @Override
    public List<Order> getByAuthor(String author) {
        return proxy.getAllByAuthor(author);
    }



    @Override
    public void save(Order order) {
        proxy.save(order);
    }

    @Override
    public Order read(String id) {
        return proxy.getById(id);
    }

    @Override
    public List<Order> readAll() {
        return proxy.findAll();
    }

    @Override
    public void update(Order o) {

    }

    @Override
    public void delete(String id) {
        proxy.deleteById(id);
    }
}
