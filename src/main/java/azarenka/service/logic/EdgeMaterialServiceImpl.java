package azarenka.service.logic;

import azarenka.entity.EdgeMaterial;
import azarenka.repository.EdgeMaterialRepository;
import azarenka.service.EdgeMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EdgeMaterialServiceImpl implements EdgeMaterialService {

    @Autowired
    private EdgeMaterialRepository repository;

    @Override
    public List<EdgeMaterial> getAll() {
        return repository.findAll();
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void save(EdgeMaterial edgeMaterial) {
        repository.save(edgeMaterial);
    }

    @Override
    public EdgeMaterial getById(Long id) {
        return repository.getById(id);
    }
}
