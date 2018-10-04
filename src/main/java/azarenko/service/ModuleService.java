package azarenko.service;

import azarenko.entity.Module;

import java.util.List;

public interface ModuleService {

    void save(Module module);

    Module getById(String id);

    List<Module> getByName(String name);



}
