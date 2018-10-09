package azarenko.repository;

import azarenko.entity.ColorMaterial;
import azarenko.repository.CrudRepository;

public interface ColorMaterialRepository  extends CrudRepository<String, ColorMaterial> {
    ColorMaterial getByName(String name);
}
