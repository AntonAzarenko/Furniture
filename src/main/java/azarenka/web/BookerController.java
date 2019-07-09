package azarenka.web;

import static azarenka.web.DetailController.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

import azarenka.dto.BookerDTO;
import azarenka.service.BookerService;

/**
 * Booker controller.
 * <p>
 * Copyright (C) 2018 Anton_Azarenka@epam.com
 * </p>
 * Date: 7/9/18
 *
 * @author Anton Azarenka
 */
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = URL + "/booker")
public class BookerController {

    @Autowired
    private BookerService service;

    /**
     * Returns list of Booker DTO.
     *
     * @param id id.
     * @return list of booker dto.
     */
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<BookerDTO> getToCostOrder(@PathVariable("id") Long id) {
        return service.getCalculationOfOrder(id);
    }

    /**
     * Returns total cost of order.
     *
     * @param id id.
     * @return total cost of order.
     */
    @GetMapping(value = "/total/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public BigDecimal getTotalCost(@PathVariable("id") Long id){
        return service.getTotalCalc(id);
    }
}
