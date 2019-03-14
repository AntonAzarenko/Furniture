package azarenka.service;

import azarenka.dto.BookerDTO;
import azarenka.entity.Fitting;

import java.util.List;

public interface BookerService {
    List<BookerDTO> getCalculationOfOrder(Long id);


}
