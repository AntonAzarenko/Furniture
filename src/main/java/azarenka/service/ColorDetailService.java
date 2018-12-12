package azarenka.service;


import azarenka.entity.DetailsColor;

import java.util.List;

public interface ColorDetailService {
    DetailsColor getByID(Long id);

    List<DetailsColor> getAll();

    void save(DetailsColor order);

    void delete(Long id);
}
