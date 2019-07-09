package azarenka.web;

import static azarenka.web.DetailController.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import azarenka.entity.Edge;
import azarenka.service.EdgeService;

/**
 * Edge controller.
 * <p>
 * Copyright (C) 2018 Anton_Azarenka@epam.com
 * </p>
 * Date: 7/9/18
 *
 * @author Anton Azarenka
 */
@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping(value = URL +"/edge")
public class EdgeController {

    @Autowired
    private EdgeService service;

    /**
     * Returns list of  detail edge.
     *
     * @return list of  detail edge {@link Edge}.
     */
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Edge> getAll() {
        return service.getAll();
    }
}
