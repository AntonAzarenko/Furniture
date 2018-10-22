package azarenka.service.logic;

import azarenka.entity.Module;
import azarenka.repository.ModuleRepository;
import azarenka.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModuleServiceImpl implements ModuleService { //TODO class uncovered by the tests

    @Autowired
    private ModuleRepository repository;

    @Override
    public void save(Module module) {
        repository.save(module);
    }

    @Override
    public Module getById(String id) {
        return repository.read(id);
    }

    @Override
    public List<Module> getByName(String name) {
        return repository.getByName(name);
    }

    @Override
    public List<Module> getAll() {
        return repository.readAll();
    }
}
