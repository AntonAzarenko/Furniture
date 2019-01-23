package azarenka.service.logic;

import azarenka.dto.BookerDTO;
import azarenka.entity.Module;
import azarenka.service.BookerService;
import azarenka.service.DetailService;
import azarenka.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BookerServiceImpl implements BookerService {

    @Autowired
    private DetailService detailService;

    @Autowired
    private ModuleService moduleService;

    @Override
    public BookerDTO getCalculationOfOrder(Long id) {
        List<Module> moduleList = moduleService.getAllByOrderId(id);
        return null;
    }
}
