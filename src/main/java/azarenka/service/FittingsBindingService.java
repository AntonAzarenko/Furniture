package azarenka.service;

import azarenka.dto.FittingsDTO;
import azarenka.entity.Fittings;

import java.util.List;

public interface FittingsBindingService {

    List<FittingsDTO> get(List<Fittings> fittings);
}
