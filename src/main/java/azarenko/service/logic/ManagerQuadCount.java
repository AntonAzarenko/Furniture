package azarenko.service.logic;

import azarenko.entity.Detail;
import azarenko.entity.Module;
import azarenko.entity.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
public class ManagerQuadCount {

    public double getCountSquareDetail(int x, int y) {
        return ((double)x / 1000) * ((double) y / 1000);
    }

    public double getCountSquareDetailsList(List<Detail> detailList) {
        double sum = 0;
        if (Objects.nonNull(detailList)) {
            for (Detail detail : detailList) {
                sum += getCountSquareDetail(detail.getX(), detail.getY());
            }
        }
        return sum;
    }

    public double getCountSquareDetailsForModule(Module module) {
        double sum = 0;
        if (Objects.nonNull(module)) {
            List<Detail> detailList = module.getDetailList();
            if (Objects.nonNull(detailList)) {
                sum = getCountSquareDetailsList(detailList);
            }
        }
        return sum;
    }

    public double getCountSquareForOrder(Order order) {
        double sum = 0;
        if (Objects.nonNull(order)) {
            List<Detail> detailList = order.getDetailList();
            List<Module> moduleList = order.getModuleList();
            if (Objects.nonNull(detailList)) {
                sum += getCountSquareDetailsList(detailList);
            }
            if (Objects.nonNull(moduleList)) {
                sum += getCountSquareDetailsForModuleList(moduleList);
            }
        }
        return sum;
    }

    public double getCountSquareDetailsForModuleList(List<Module> moduleList) {
        double sum = 0;
        if (Objects.nonNull(moduleList)) {
            for (Module module : moduleList) {
                sum += getCountSquareDetailsForModule(module);
            }
        }
        return sum;
    }
}

