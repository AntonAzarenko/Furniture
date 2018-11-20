package azarenka.service;

import azarenka.entity.Module;

import java.util.List;

public interface ModuleService {

    void save(Module module);

    Module getById(Long id);

    List<Module> getByName(String name);

    List<Module> getAll();




}
