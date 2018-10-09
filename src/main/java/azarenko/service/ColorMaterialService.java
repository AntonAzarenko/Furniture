package azarenko.service;


import azarenko.entity.ColorMaterial;

import java.util.List;

public interface ColorMaterialService {
    ColorMaterial getByID(String id);

    List<ColorMaterial> getAll();

    ColorMaterial getByName(String name);

    void save(ColorMaterial order);

    void delete(String id);
}
