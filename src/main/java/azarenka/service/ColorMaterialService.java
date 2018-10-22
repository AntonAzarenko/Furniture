package azarenka.service;


import azarenka.entity.ColorMaterial;
import azarenka.exceptions.NotFoundException;

import java.util.List;

public interface ColorMaterialService {
    ColorMaterial getByID(String id);

    List<ColorMaterial> getAll();

    ColorMaterial getByName(String name) throws NotFoundException;

    void save(ColorMaterial order);

    void delete(String id);
}
