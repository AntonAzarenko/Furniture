package azarenko.repository;

import azarenko.entity.Module;
import azarenko.repository.CrudRepository;

import java.util.List;

public interface ModuleRepository extends CrudRepository<String, Module> {
     List<Module> getByName(String name);
}
