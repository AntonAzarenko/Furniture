package azarenko.repository.logic.proxy;

import azarenko.entity.Module;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProxyModuleRepository extends MongoRepository<Module, String> {

    Module getById(String id);
}
