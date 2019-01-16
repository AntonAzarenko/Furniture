package azarenka.service.logic;

import azarenka.entity.Detail;
import azarenka.repository.DetailRepository;
import azarenka.service.DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetailServiceImpl implements DetailService {

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
    public Detail save(Detail detail) {
        return repository.save(detail);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Detail> getByModuleId(Long id) {
        return repository.getAllByModule_Id(id);
    }

    @Override
    public void delete(List<Detail> list) {
        for (Detail cur : list) {
            repository.delete(cur);
        }
    }
}
