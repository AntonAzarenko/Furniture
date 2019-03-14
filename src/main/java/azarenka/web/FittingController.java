package azarenka.web;

import org.springframework.web.bind.annotation.*;

import static azarenka.web.DetailController.URL;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = URL + "/fitting")
public class FittingController {


}
