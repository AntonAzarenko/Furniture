package azarenka.service;

import azarenka.entity.EdgeMaterial;

import java.util.List;
import java.util.Set;

public interface EdgeMaterialService {

    List<EdgeMaterial> getAll();

    void delete(Long id);

    void save(EdgeMaterial edgeMaterial);

    EdgeMaterial getById(Long id);

    Set<EdgeMaterial> getAllByDetailId(Long id);
}
