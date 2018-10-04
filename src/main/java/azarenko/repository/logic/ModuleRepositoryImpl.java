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
    private ProxyModuleRepository repository;

    @Override
    public void save(Module module) {
        repository.save(module);
    }

    @Override
    public Module read(String id) {
        return repository.getById(id);
    }

    @Override
    public List<Module> readAll() {
        return repository.findAll();
    }

    @Override
    public void update(Module o) {
        save(o);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }
}
