package azarenka.web;

import azarenka.dto.BookerDTO;
import azarenka.service.BookerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

import static azarenka.web.DetailController.URL;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = URL + "/booker")
public class BookerController {

    @Autowired
    private BookerService service;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<BookerDTO> getToCostOrder(@PathVariable("id") Long id) {
        return service.getCalculationOfOrder(id);
    }

    @GetMapping(value = "/total/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public BigDecimal getTotalCost(@PathVariable("id") Long id){
        return service.getTotalCalc(id);
    }
}
