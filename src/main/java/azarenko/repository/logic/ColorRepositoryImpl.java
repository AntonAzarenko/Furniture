package azarenko.repository.logic;

import azarenko.entity.ColorMaterial;
import azarenko.repository.ColorMaterialRepository;
import azarenko.repository.logic.proxy.ProxyColorMaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ColorRepositoryImpl implements ColorMaterialRepository {

    @Autowired
    private ProxyColorMaterialRepository proxy;

    @Override
    public void save(ColorMaterial colorMaterial) {
        proxy.save(colorMaterial);
    }

    @Override
    public ColorMaterial read(String id) {
        return proxy.getById(id);
    }

    @Override
    public List<ColorMaterial> readAll() {
        return proxy.findAll();
    }

    @Override
    public void update(ColorMaterial colorMaterial) {
        save(colorMaterial);
    }

    @Override
    public void delete(String id) {
        proxy.deleteById(id);
    }

    @Override
    public ColorMaterial getByName(String name) {
       return proxy.getByTitle(name);
    }
}
