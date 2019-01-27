package azarenka.service;

import azarenka.dto.BookerDTO;

import java.util.List;

public interface BookerService {
    List<BookerDTO> getCalculationOfOrder(Long id);
}
