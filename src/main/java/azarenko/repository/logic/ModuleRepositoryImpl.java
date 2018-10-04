package azarenko.repository.logic;

import azarenko.entity.Module;
import azarenko.repository.ModuleRepository;
import azarenko.repository.logic.proxy.ProxyModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ModuleRepositoryImpl implements ModuleRepository {

    @Autowired
    private ProxyModuleRepository proxy;

    @Override
    public void save(Module module) {
        proxy.save(module);
    }

    @Override
    public Module read(String id) {
        return proxy.getById(id);
    }

    @Override
    public List<Module> readAll() {
        return proxy.findAll();
    }

    @Override
    public void update(Module o) {
        save(o);
    }

    @Override
    public void delete(String id) {
        proxy.deleteById(id);
    }

    @Override
    public List<Module> getByName(String name) {
        return proxy.getByName(name);
    }
}
