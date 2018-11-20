package azarenka.repository;

import azarenka.entity.Module;

import java.util.List;

public interface ModuleRepository  {
     List<Module> getByName(String name);
     Module getById (Long id);
}
