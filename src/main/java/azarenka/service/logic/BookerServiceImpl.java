package azarenka.service.logic;

import azarenka.dto.BookerResponse;
import azarenka.entity.Module;
import azarenka.service.BookerService;
import azarenka.service.DetailService;
import azarenka.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookerServiceImpl implements BookerService {

    @Autowired
    private BookerResponse bookerResponse;

    @Autowired
    private DetailService detailService;

    @Autowired
    private ModuleService moduleService;

    @Override
    public List<BookerResponse> getCalculationOfOrder(Long id) {
        List<BookerResponse> bookerResponseList = new ArrayList<>();
        List<Module> moduleList = moduleService.getAllByOrderId(id);
        for (Module current : moduleList) {
            current.setDetailList(detailService.getByModuleId(current.getId()));
            bookerResponseList.add(bookerResponse.asBookerDTO(current));
        }
        return bookerResponseList;
    }
}
