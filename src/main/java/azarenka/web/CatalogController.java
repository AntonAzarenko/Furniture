package azarenka.web;

import static azarenka.web.DetailController.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import azarenka.entity.fitting.Handle;
import azarenka.entity.fitting.params.HandleParams;
import azarenka.service.HandleService;

/**
 * Catalog controller.
 * <p>
 * Copyright (C) 2018 Anton_Azarenka@epam.com
 * </p>
 * Date: 7/9/18
 *
 * @author Anton Azarenka
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = URL + "/catalog")
public class CatalogController {

    @Autowired
    private HandleService service;

    /**
     * Returns list of hadles.
     *
     * @return list of hadles.
     */
    @GetMapping(value = "/handles",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Handle> getHandles(){
        List<Handle> list = service.getAll();
        return service.getAll();
    }

    /**
     * Returns handle params.
     *
     * @param id handle id.
     * @return handle params.
     */
    @GetMapping(value = "/handles/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<HandleParams> getParam(@PathVariable("id") Long id){
        return service.getAllParamsById(id);
    }
}
