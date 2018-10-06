package azarenko.service.logic;

import azarenko.entity.*;
import org.springframework.stereotype.Component;

import java.util.List;

import static azarenko.entity.ButtClose.BUTT_X;

@Component
public class ManagerEdgeCount {

    public double getLengthEdgeMaterialForOrder(Order order) {
        double sum = 0d;
        List<Module> moduleList = order.getModuleList();
        List<Detail> detailList = order.getDetailList();
        for(Module module : moduleList){
            sum+= getLengthEdgeMaterialForModule(module);
        }

        for (Detail detail : detailList){
            sum+= getLengthEdgeMaterialForDetail(detail);
        }
        return sum;
    }

    public double getLengthEdgeMaterialForModule(Module module) {
        return getLengthEdgeMaterialForDetailList(module.getDetailList());
    }

    public double getLengthEdgeMaterialForDetailList(List<Detail> detailList) {
        double sum = 0d;
        for (Detail detail : detailList) {
            sum += getLengthEdgeMaterialForDetail(detail);
        }
        return sum;
    }

    public double getLengthEdgeMaterialForDetail(Detail detail) {
        double sum = getButtClose(detail.getX(), detail.getY(), detail.getEdgeMaterial());
        return sum = sum + (sum / 100 * 10);
    }

    private double getButtClose(int x, int y, List<EdgeMaterial> edgeMaterials) {
        double sum = 0d;
        for (EdgeMaterial material : edgeMaterials) {
            sum += getlength(x, y, material);
        }
        return sum;
    }

    private double getlength(int x, int y, EdgeMaterial material) {
        switch (material.getButtCloses()) {
            case BUTT_X:
                return (double) x;
            case BUTT_Y:
                return (double) y;
            case BUTT_DOUBLE_X:
                return (double) x * 2;
            case BUTT_DOUBLE_Y:
                return (double) y * 2;
            case BUTT_X_AND_Y:
                return (double) x + y;
            case BUTT_ARROUND:
                return (double) x * 2 + y * 2;
            case BUTT_DOUBLE_X_AND_Y:
                return (double) x * 2 + y;
            case BUTT_DOUBLE_Y_AND_X:
                return (double) y * 2 + x;
        }
        return 0d;
    }
}
