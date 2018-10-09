package azarenko.service.logic;

import azarenko.entity.ColorMaterial;
import azarenko.repository.ColorMaterialRepository;
import azarenko.service.ColorMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColorMaterialImpl implements ColorMaterialService {

    @Autowired
    private ColorMaterialRepository repository;

    @Override
    public ColorMaterial getByID(String id) {
        return repository.read(id);
    }

    @Override
    public List<ColorMaterial> getAll() {
        return repository.readAll();
    }

    @Override
    public ColorMaterial getByName(String name) {
        return repository.getByName(name);
    }

    @Override
    public void save(ColorMaterial colorMaterial) {
        repository.save(colorMaterial);
    }

    @Override
    public void delete(String id) {
        repository.delete(id);
    }
}
