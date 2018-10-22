package azarenka.web;

import azarenka.entity.ColorMaterial;
import azarenka.entity.Order;
import azarenka.exceptions.NotFoundException;
import azarenka.service.ColorMaterialService;
import azarenka.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin(maxAge = 3600)
@RequestMapping(value = "color")
public class ColorMaterialController {

    @Autowired
    private ColorMaterialService service;

    @RequestMapping(method = RequestMethod.GET, value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ColorMaterial> getAll() {
        return service.getAll();
    }

    @PostMapping(value = "/remove/{id}")
    public void remove(@PathVariable("id")String id){
        service.delete(id);
    }

    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void add(ColorMaterial colorMaterial){
        service.save(colorMaterial);
    }

    @GetMapping(value = "/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ColorMaterial get(@PathVariable("id")String id){
        return service.getByID(id);
    }

    @GetMapping(value = "/getByName/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ColorMaterial getByName(@PathVariable("name")String name){
        try {
            return service.getByName(name);
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
