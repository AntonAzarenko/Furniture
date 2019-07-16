package azarenka.service.logic;

import azarenka.dto.DetailResponse;
import azarenka.entity.Detail;
import azarenka.entity.Module;
import azarenka.repository.DetailRepository;
import azarenka.service.DetailService;
import azarenka.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DetailServiceImpl implements DetailService {

    @Autowired
    private DetailRepository repository;

    @Autowired
    private ModuleService moduleService;

    @Autowired
    private DetailResponse detailResponse;

    @Override
    public List<Detail> getAll() {
        return repository.findAll();
    }

    @Override
    public Detail getById(Long id) {
        return repository.getById(id);
    }

    @Override
    @Transactional
    public Detail save(Detail detail) {
        //TODO
        return repository.save(detail);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<DetailResponse> getDTOByModuleId(Long id) {
        List<Detail> details = repository.getAllByModule_Id(id);
        List<DetailResponse> detailResponseList = detailResponse.asDetailDTO(details);
        return detailResponseList;
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

    @Override
    public Module getNameById(Long id) {
        Module module = moduleService.getById(id);
        return module;
    }
}
