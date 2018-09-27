package azarenko.repository.logic;

import azarenko.entity.Detail;
import azarenko.repository.DetailRepository;
import azarenko.repository.logic.proxy.ProxyDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DetailRepositoryImpl implements DetailRepository {

    @Autowired
    private ProxyDetailRepository proxy;

    @Override
    public Detail getByName(String name) {
        return proxy.findByName(name);
    }

    @Override
    public void save(Detail detail) {
        proxy.save(detail);
    }

    @Override
    public Detail read(Long id) {
        return proxy.findById(id);
    }

    @Override
    public List<Detail> readAll() {
        return proxy.findAll();
    }

    @Override
    public void update(Detail detail) {
        proxy.save(detail);
    }

    @Override
    public void delete(Long id) {
        proxy.deleteById(id);
    }
}
