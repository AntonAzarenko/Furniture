package azarenka.web;

import azarenka.entity.Edge;
import azarenka.service.EdgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static azarenka.web.DetailController.URL;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping(value = URL +"/edge")
public class EdgeController {

    @Autowired
    private EdgeService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Edge> getAll() {
        return service.getAll();
    }
}
