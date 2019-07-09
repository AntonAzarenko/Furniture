package azarenka.service.logic.fittings;

import azarenka.dto.FittingsDTO;
import azarenka.entity.Fittings;
import azarenka.entity.fitting.Handle;
import azarenka.entity.fitting.oforder.HandleOfOrder;
import azarenka.entity.fitting.params.HandleColors;
import azarenka.entity.fitting.params.HandleParams;
import azarenka.service.FittingsBindingService;
import azarenka.service.HandleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FittingsBindingServiceImpl implements FittingsBindingService {

    @Autowired
    private HandleService handleService;

    @Override
    public List<FittingsDTO> get(List<Fittings> fittings) {
        List<FittingsDTO> fittingsDTOS = new ArrayList<>();
        for (Fittings current : fittings) {
            FittingsDTO dto = init();
            intiType(dto, current);
            dto.setCount(current.getCount());
            fittingsDTOS.add(dto);
        }
        return fittingsDTOS;
    }


    private FittingsDTO init() {
        return new FittingsDTO();
    }

    private void intiType(FittingsDTO dto, Fittings fittings) {
        if (fittings.getHandle() != null) {
            dto.setType("Ручка");
            getInternalObjects(fittings.getHandle().getId(), dto);
        }
    }

    private void getInternalObjects(Long handleOfOrderId, FittingsDTO fittingsDTO) {
        HandleOfOrder handleOfOrders = handleService.getHandleOfOrderByModuleId(handleOfOrderId);
        Handle handle = getHandle(handleOfOrders);
        HandleParams params = getParams(handleOfOrders);
        HandleColors colors = getColors(handleOfOrders);
        setFieldsOfHandle(handle, fittingsDTO);
        setFieldsOfHandleParam(params, fittingsDTO);
        setFieldOfHandleColor(colors, fittingsDTO);
    }

    private void setFieldOfHandleColor(HandleColors handleColor, FittingsDTO dto) {
        dto.setColor(handleColor.getColor().toString());
        if (handleColor.getOtherColor() != null) {
            dto.setColor(handleColor.getOtherColor());
        }
    }

    private void setFieldsOfHandleParam(HandleParams handleParam, FittingsDTO dto) {
        dto.setSize(handleParam.getCenterDistance());
        dto.setPrice(handleParam.getPrice());
    }

    private void setFieldsOfHandle(Handle handle, FittingsDTO dto) {
        dto.setArticle(handle.getArticle());
        dto.setCountry(handle.getCountry());
    }

    private Handle getHandle(HandleOfOrder handleOfOrder) {
        Long handleId = handleOfOrder.getHandleId();
        return handleService.getById(handleId);
    }

    private HandleParams getParams(HandleOfOrder handleOfOrder) {
        Long handleParamsId = handleOfOrder.getHandleParamId();
        return handleService.getParamsById(handleParamsId);
    }

    private HandleColors getColors(HandleOfOrder handleOfOrder) {
        Long colorsId = handleOfOrder.getHandleColorId();
        return handleService.getHandleColorsById(colorsId);
    }


}
