package azarenka.repository.logic.proxy;

import azarenka.entity.ColorMaterial;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProxyColorMaterialRepository extends MongoRepository<ColorMaterial, String> {
        ColorMaterial getById(String id);

        ColorMaterial findByTitle(String name);
}
