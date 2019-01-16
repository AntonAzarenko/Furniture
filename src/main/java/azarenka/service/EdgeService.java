package azarenka.service;

import azarenka.entity.Edge;
import azarenka.entity.EdgeMaterial;

import java.util.List;

public interface EdgeService {

    List<Edge> getAll();

    void delete(Long id);

    void save(Edge edgeMaterial);

    Edge getById(Long id);
}
