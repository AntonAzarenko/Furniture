package azarenka.service;

import azarenka.dto.DetailResponse;
import azarenka.entity.Detail;
import azarenka.entity.Module;

import java.util.List;


public interface DetailService {

    List<Detail> getAll();

    Detail getById(Long id);

    Detail save(Detail detail);

    void delete(Long id);

    List<DetailResponse> getDTOByModuleId(Long id);

    List<Detail> getByModuleId(Long id);

    void delete(List<Detail> list);

    Module getNameById(Long id);
}
