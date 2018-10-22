package azarenka.repository.logic;

import azarenka.entity.Order;
import azarenka.repository.logic.proxy.ProxyOrderRepository;
import azarenka.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderRepositoryImpl implements OrderRepository {
    @Autowired
    private ProxyOrderRepository proxy;

    @Override
    public List<Order> getByName(String name) {
        return proxy.getByName(name);
    }

    @Override
    public List<Order> getByAuthor(String firstName) {
        return proxy.getAllByAuthor(firstName);
    }

    @Override
    public List<Order> getByModuleName(String name) { //TODO cover by the test. I see that this method is not implemented, but test should exist
        return null;
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
    public void update(Order o) { //TODO cover by the tests
        proxy.save(o);
    }

    @Override
    public void delete(String id) {
        proxy.deleteById(id);
    }
}
