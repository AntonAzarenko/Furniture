package azarenka.service;

import azarenka.dto.FittingsDTO;
import azarenka.entity.Fittings;

import java.util.List;

public interface FittingsService {

    Fittings addHandleToOrder(Fittings fittings);

    Fittings save(Fittings fittings);

    List<FittingsDTO> getAllFittingsOfModule(Long moduleId);

    List<Fittings> getFittingsOfModule(Long moduleId);
}
