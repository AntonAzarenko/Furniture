package azarenka.service.logic;

import azarenka.entity.ColorMaterial;
import azarenka.exceptions.NotFoundException;
import azarenka.repository.ColorMaterialRepository;
import azarenka.service.ColorMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ColorMaterialServiceImpl implements ColorMaterialService {

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
    public ColorMaterial getByName(String name) throws NotFoundException {
        ColorMaterial colorMaterial = repository.getByName(name);
        if (Objects.isNull(colorMaterial)) throw new NotFoundException(" Not found entity with name " + name);
        return colorMaterial;
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
