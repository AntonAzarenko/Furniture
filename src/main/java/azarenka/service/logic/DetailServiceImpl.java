package azarenka.service.logic;

import azarenka.entity.Detail;
import azarenka.repository.DetailRepository;
import azarenka.service.DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetailServiceImpl implements DetailService{

    @Autowired
    private DetailRepository repository;

    @Override
    public List<Detail> getAll() {
        return repository.findAll();
    }

    @Override
    public Detail getById(Long id) {
        return repository.getById(id);
    }

    @Override
    public void save(Detail detail) {
        repository.save(detail);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
