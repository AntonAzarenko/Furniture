package azarenka.web;

import azarenka.dto.OrderDTO;
import azarenka.entity.Order;
import azarenka.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static azarenka.web.DetailController.URL;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = URL + "/order")
public class OrderController {

    @Autowired
    private OrderService service;

    @GetMapping(value = "/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<OrderDTO> getAllByUser(@PathVariable("name") String name) {
        return service.getAllByUserName(name);
    }

    @DeleteMapping(value = "/{id}")
    public void remove(@PathVariable("id") Long id) {
        service.deleteById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void save(@RequestBody OrderDTO order) {
        service.create(order.asOrder());
    }

   /* @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Order getById(@PathVariable("id") Long id) {
        return service.getByID(id);
    }*/

}
