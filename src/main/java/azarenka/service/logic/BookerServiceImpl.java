package azarenka.service.logic;

import azarenka.dto.BookerDTO;
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
    private BookerDTO bookerDTO;

    @Autowired
    private DetailService detailService;

    @Autowired
    private ModuleService moduleService;

    @Override
    public List<BookerDTO> getCalculationOfOrder(Long id) {
        List<BookerDTO> bookerDTOList = new ArrayList<>();
        List<Module> moduleList = moduleService.getAllByOrderId(id);
        for (Module current : moduleList) {
            current.setDetailList(detailService.getByModuleId(current.getId()));
            bookerDTOList.add(bookerDTO.asBookerDTO(current));
        }
        return bookerDTOList;
    }
}
