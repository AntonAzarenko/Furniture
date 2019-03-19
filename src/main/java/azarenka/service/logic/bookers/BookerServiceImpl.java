package azarenka.service.logic.bookers;

import azarenka.dto.BookerDTO;
import azarenka.entity.Material;
import azarenka.entity.Module;
import azarenka.service.BookerService;
import azarenka.service.DetailService;
import azarenka.service.FittingsService;
import azarenka.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookerServiceImpl implements BookerService {

    @Autowired
    private BookerDTO bookerDTO;

    @Autowired
    private Booker booker;

    @Autowired
    private FittingsService fittingsService;

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
            current.setFittings(fittingsService.getFittingsOfModule(current.getId()));
            bookerDTOList.add(asBookerDTO(current));
        }
        return bookerDTOList;
    }

    @Override
    public BigDecimal getTotalCalc(Long id) {
        List<BookerDTO> bookerDTOList = getCalculationOfOrder(id);
        return booker.getTotalPriceOfOrder(bookerDTOList);
    }

    private BookerDTO asBookerDTO(Module module) {
        BookerDTO bookerDTO = new BookerDTO();
        bookerDTO.setModuleName(module.getName());
        bookerDTO.setModuleType(module.getModuleType().toString());
        bookerDTO.setPriceForSquareDSP(getCostSquareDSP(module));
        bookerDTO.setPriceForSquareDVP(getCostSquareDVP(module));
        bookerDTO.setPriceForEdge(getCostLengthEdge(module));
        bookerDTO.setPriceForFitting(getPriceForFittings(module));
        bookerDTO.setTotal(getPriceTotalOFModule(module));
        return bookerDTO;
    }

    private BigDecimal getPriceForFittings(Module module) {
        return booker.getPriceModuleFitting(module);
    }

    private BigDecimal getPriceTotalOfOrder(Module module) {
        return booker.getPriceOrder(module.getOrder());
    }

    private BigDecimal getCostLengthEdge(Module module) {
        return booker.getPriceEdgeByModule(module);
    }

    private BigDecimal getCostSquareDSP(Module module) {
        return booker.getPriceDetailByType(module, Material.DSP);
    }

    private BigDecimal getCostSquareDVP(Module module) {
        return booker.getPriceDetailByType(module, Material.DVP);
    }

    private BigDecimal getCostSquareWOOD(Module module) {
        return booker.getPriceDetailByType(module, Material.WOOD);
    }

    private BigDecimal getCostSquareMDF(Module module) {
        return booker.getPriceDetailByType(module, Material.MDF);
    }

    private BigDecimal getPriceTotalOFModule(Module module) {
        return booker.getPriceModule(module);
    }
}
