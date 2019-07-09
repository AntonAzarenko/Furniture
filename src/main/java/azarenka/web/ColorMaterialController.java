package azarenka.web;

import static azarenka.web.DetailController.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import azarenka.entity.DetailsColor;
import azarenka.service.ColorDetailService;

/**
 * Color Material controller.
 * <p>
 * Copyright (C) 2018 Anton_Azarenka@epam.com
 * </p>
 * Date: 7/9/18
 *
 * @author Anton Azarenka
 */
@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping(value = URL + "/color")
public class ColorMaterialController {

    @Autowired
    private ColorDetailService service;

    /**
     * Returns list of details.
     *
     * @return list of details.
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DetailsColor> getAll() {
        return service.getAll();
    }

    /**
     * Removes material color.
     *
     * @param id material color id.
     */
    @DeleteMapping(value = "/{id}")
    public void remove(@PathVariable("id")Long id){
        service.delete(id);
    }

    /**
     * Adds color of detail.
     *
     * @param detailsColor color of detail.
     */
    @PostMapping( consumes = MediaType.APPLICATION_JSON_VALUE)
    public void add(DetailsColor detailsColor){
        service.save(detailsColor);
    }

    /**
     * Returns detail color by id.
     *
     * @param id detail color id.
     * @return  detail color by id
     */
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public DetailsColor get(@PathVariable("id")Long id){
        return service.getByID(id);
    }
}
