package azarenka.web;

import azarenka.dto.fittingdto.FittingDTO;
import azarenka.dto.fittingdto.HandleDTO;
import azarenka.entity.Fitting;
import azarenka.entity.furnitures.Handle;
import azarenka.entity.furnitures.HandleColor;
import azarenka.service.FittingService;
import azarenka.service.HandleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

import static azarenka.web.DetailController.URL;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = URL + "/fitting/handle")
public class HandleController {

    @Autowired
    private HandleService service;

    @Autowired
    FittingService fittingService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> save(@RequestBody HandleDTO handleDTO) {
        Handle handle = null;
        try {
            handle = service.save(handleDTO.asHandle());
            handleDTO.setHandle(handle);
            service.addHandleParams(handleDTO.asHandleParams());
        } catch (Exception e) {
            String error = e.getMessage();
            service.deleteById(handle.getId());
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(error);
        }
        return ResponseEntity.status(HttpStatus.OK).body("Ручка успешно добавлена");
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Set<HandleColor> getColors(@PathVariable("id") Long id) {
        return service.getHandleColorsByHandleId(id);
    }

    @PostMapping(value = "/add",consumes = MediaType.APPLICATION_JSON_VALUE)
    public Fitting add(@RequestBody FittingDTO fittingDTO){
        return fittingService.addHandleToOrder(fittingDTO.asFitting());
    }
}
