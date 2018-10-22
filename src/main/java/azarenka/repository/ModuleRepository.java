package azarenka.repository;

import azarenka.entity.Module;

import java.util.List;

public interface ModuleRepository extends CrudRepository<String, Module> {
     List<Module> getByName(String name);
}
