package azarenka.web;

import azarenka.entity.Order;
import azarenka.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping(value = "order")
public class OrderController {

    @Autowired
    private OrderService service;

    @RequestMapping(method = RequestMethod.GET, value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Order> getAll() {
        return service.getAll();
    }

    @PostMapping(value = "/remove/{id}")
    public void remove(@PathVariable("id")String id){
        service.delete(id);
    } //TODO cover with tests

    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void add(Order order){
        service.create(order);
    }

    @GetMapping(value = "/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Order get(@PathVariable("id")String id){
       return service.getByID(id);
    } //TODO cover with tests

    @GetMapping(value = "/getByName/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Order> getByName(@PathVariable("name")String name){
        return service.getByName(name);
    }
}
