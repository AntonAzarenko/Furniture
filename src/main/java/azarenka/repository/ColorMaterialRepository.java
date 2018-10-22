package azarenka.repository;

import azarenka.entity.ColorMaterial;

public interface ColorMaterialRepository  extends CrudRepository<String, ColorMaterial> {
    ColorMaterial getByName(String name);
}
