package azarenka.service;

import azarenka.entity.EdgeMaterial;

import java.util.List;

public interface EdgeMaterialService {

    List<EdgeMaterial> getAll();

    void delete(Long id);

    void save(EdgeMaterial edgeMaterial);

    EdgeMaterial getById(Long id);
}
