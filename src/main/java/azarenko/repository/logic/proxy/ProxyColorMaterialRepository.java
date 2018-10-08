package azarenko.repository.logic.proxy;

import azarenko.entity.ColorMaterial;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProxyColorMaterialRepository extends MongoRepository<ColorMaterial, String> {

}
