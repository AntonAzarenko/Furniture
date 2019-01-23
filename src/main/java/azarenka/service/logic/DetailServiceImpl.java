package azarenka.service.logic;

import azarenka.dto.DetailDTO;
import azarenka.entity.Detail;
import azarenka.repository.ColorMaterialRepository;
import azarenka.repository.DetailRepository;
import azarenka.service.DetailService;
import azarenka.service.EdgeMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DetailServiceImpl implements DetailService {

    @Autowired
    private DetailRepository repository;

    @Autowired
    private DetailDTO detailDTO;

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
    public List<DetailDTO> getDTOByModuleId(Long id) {
        List<Detail> details = repository.getAllByModule_Id(id);
        List<DetailDTO> detailDTOList = detailDTO.asDetailDTO(details);
        return detailDTOList;
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
