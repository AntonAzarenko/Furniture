package azarenka.service;

import azarenka.dto.BookerResponse;

import java.util.List;

public interface BookerService {
    List<BookerResponse> getCalculationOfOrder(Long id);
}
