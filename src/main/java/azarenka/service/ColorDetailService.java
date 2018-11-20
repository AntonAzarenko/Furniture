package azarenka.service;


import azarenka.entity.ColorDetail;
import azarenka.exceptions.NotFoundException;

import java.util.List;

public interface ColorDetailService {
    ColorDetail getByID(Long id);

    List<ColorDetail> getAll();

    void save(ColorDetail order);

    void delete(Long id);
}
