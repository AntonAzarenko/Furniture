package azarenka.service;

import azarenka.dto.BookerResponse;

import java.math.BigDecimal;
import java.util.List;

public interface BookerService {

    List<BookerResponse> getCalculationOfOrder(Long id);

    BigDecimal getTotalCalc(Long id);

}
