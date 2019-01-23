package azarenka.service;

import azarenka.dto.BookerDTO;
import org.springframework.stereotype.Service;

@Service
public interface BookerService {
        BookerDTO getCalculationOfOrder(Long id);
}
