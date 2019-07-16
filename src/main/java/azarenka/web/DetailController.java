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

import azarenka.dto.DetailResponse;
import azarenka.entity.Detail;
import azarenka.entity.Module;
import azarenka.service.DetailService;

/**
 * Detail controller.
 * <p>
 * Copyright (C) 2018 Anton_Azarenka@epam.com
 * </p>
 * Date: 7/9/18
 *
 * @author Anton Azarenka
 */
@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
@RequestMapping(value = URL +"/detail")
public class DetailController {

    public static final String URL = "/furniture";

    @Autowired
    private DetailService service;

    /**
     * Returns full list of details.
     *
     * @return full list of details.
     */
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Detail> getAll(){
        return service.getAll();
    }

    /**
     * Returns full list of details for REST API.
     *
     * @param id id of details .
     * @return full list of details for REST API.
     */
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DetailResponse> getAllByModuleId(@PathVariable("id") Long id){
        return service.getDTOByModuleId(id);
    }

    /**
     * Removes delete detail by id.
     *
     * @param id details id.
     */
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Long id){
        service.delete(id);
    }

    /**
     * Saves detail and returns it on UI.
     *
     * @param detailResponse details dto {@link DetailResponse}
     * @return details {@link Detail}
     */
    @PostMapping (consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Detail save(@RequestBody DetailResponse detailResponse){
        return service.save(detailResponse.asDetail());
    }

    @Deprecated
    @CrossOrigin
    @DeleteMapping(value = "/del/",consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAll(@RequestBody List<Detail> list){
        service.delete(list);
    }

    /**
     * Returns module by id {@link Module}.
     *
     * @param id module id
     * @return module id.
     */
    @GetMapping(value = "/name/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public Module getNameById(@PathVariable("id") Long id){
        return service.getNameById(id);
    }
}
