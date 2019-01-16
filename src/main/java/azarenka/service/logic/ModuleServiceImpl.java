package azarenka.service.logic;

import azarenka.entity.Module;
import azarenka.repository.ModuleRepository;
import azarenka.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModuleServiceImpl implements ModuleService {

    @Autowired
    private ModuleRepository repository;

    @Override
    public Module save(Module module) {
        return repository.save(module);
    }

    @Override
    public Module getById(Long id) {
        return null;
    }

    @Override
    public List<Module> getByName(String name) {
        return null;
    }

    @Override
    public List<Module> getAll() {
        return repository.findAll();
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Module> getAllByOrderId(Long id) {
        return repository.getAllByOrder_Id(id);
    }
}
