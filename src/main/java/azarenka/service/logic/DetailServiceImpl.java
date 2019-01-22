package azarenka.service.logic;

import azarenka.dto.DetailDTO;
import azarenka.entity.Detail;
import azarenka.entity.DetailsColor;
import azarenka.entity.EdgeMaterial;
import azarenka.repository.ColorMaterialRepository;
import azarenka.repository.DetailRepository;
import azarenka.service.DetailService;
import azarenka.service.EdgeMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class DetailServiceImpl implements DetailService {

    @Autowired
    private ColorMaterialRepository colorMaterialRepository;

    @Autowired
    private EdgeMaterialService edgeMaterialService;

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
    public Detail save(Detail detail) {
       /* DetailsColor color = colorMaterialRepository.getById(detail.getDetailsColor().getId());
        detail.setDetailsColor(color);*/
        Set<EdgeMaterial> edgeMaterial = detail.getEdgeMaterial();
        for(EdgeMaterial cur : edgeMaterial){
            if(cur.getId() == null){
                edgeMaterialService.save(cur);
            }
        }
        return repository.save(detail);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<DetailDTO> getByModuleId(Long id) {
        List<Detail> details = repository.getAllByModule_Id(id);
        List<DetailDTO> detailDTOList = detailDTO.asDetailDTO(details);
        return detailDTOList;
    }

    @Override
    public void delete(List<Detail> list) {
        for (Detail cur : list) {
            repository.delete(cur);
        }
    }
}
