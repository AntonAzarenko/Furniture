package azarenka.service.logic;

import azarenka.entity.ColorDetail;
import azarenka.exceptions.NotFoundException;
import azarenka.repository.ColorMaterialRepository;
import azarenka.repository.mybatis.ColorDetailMapper;
import azarenka.service.ColorDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ColorDetailServiceImpl implements ColorDetailService {

    @Autowired
    private ColorMaterialRepository repository;

    @Override
    public ColorDetail getByID(Long id) {
        return repository.getById(id);
    }

    @Override
    public List<ColorDetail> getAll() {
        return repository.findAll();
    }

    @Override
    public void save(ColorDetail colorDetail) {
        repository.save(colorDetail);
    }

    @Override
    public void delete(Long id) {
        repository.delete(id);
    }
}
