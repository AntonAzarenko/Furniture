package azarenka.web;

import static azarenka.web.DetailController.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import azarenka.dto.OrderDTO;
import azarenka.entity.Order;
import azarenka.service.OrderService;

/**
 * Edge controller.
 * <p>
 * Copyright (C) 2018 Anton_Azarenka@epam.com
 * </p>
 * Date: 7/9/18
 *
 * @author Anton Azarenka
 */
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = URL + "/order")
public class OrderController {

    @Autowired
    private OrderService service;

    /**
     * Returns  list of  orders {@link OrderDTO}
     *
     * @param name
     * @return
     */
    @GetMapping(value = "/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<OrderDTO> getAllByUser(@PathVariable("name") String name) {
        return service.getAllByUserName(name);
    }

    /**
     * Removes order by id.
     *
     * @param id order id.
     */
    @DeleteMapping(value = "/{id}")
    public void remove(@PathVariable("id") Long id) {
        service.deleteById(id);
    }

    /**
     * Creates new order.
     *
     * @param order new order.
     * @return order.
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Order save(@RequestBody OrderDTO order) {
        return service.create(order.asOrder());
    }

}
