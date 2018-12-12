package azarenka.service.logic;

import azarenka.entity.DetailsColor;
import azarenka.repository.ColorMaterialRepository;
import azarenka.service.ColorDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColorDetailServiceImpl implements ColorDetailService {

    @Autowired
    private ColorMaterialRepository repository;

    @Override
    public DetailsColor getByID(Long id) {
        return repository.getById(id);
    }

    @Override
    public List<DetailsColor> getAll() {
        return repository.findAll();
    }

    @Override
    public void save(DetailsColor detailsColor) {
        repository.save(detailsColor);
    }

    @Override
    public void delete(Long id) {
        repository.delete(id);
    }
}
