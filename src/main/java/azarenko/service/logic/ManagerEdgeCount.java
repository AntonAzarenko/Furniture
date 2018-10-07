package azarenko.service.logic;

import azarenko.entity.*;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static azarenko.entity.ButtClose.BUTT_X;

@Component
public class ManagerEdgeCount {

    public Map<EdgeType,Double> getLengthEdgeMaterialForOrder(Order order) {
        Map<EdgeType, Double> map = new HashMap<>();
        List<Module> moduleList = order.getModuleList();
        List<Detail> detailList = order.getDetailList();
        if(Objects.nonNull(moduleList)) {
            for (Module module : moduleList) {
                map = getLengthEdgeMaterialForModule(module);
            }
        }
        if(Objects.nonNull(detailList)) {
            for (Detail detail : detailList) {
                map.putAll(getLengthEdgeMaterialForDetailList(detailList));
            }
        }
        return map;
    }

    public Map<EdgeType,Double> getLengthEdgeMaterialForModule(Module module) {
        return getLengthEdgeMaterialForDetailList(module.getDetailList());
    }

    public Map<EdgeType,Double> getLengthEdgeMaterialForDetailList(List<Detail> detailList) {
        Map<EdgeType, Double> map = new HashMap<>();
        if(Objects.nonNull(detailList)) {
            for (Detail detail : detailList) {
                map =  getLengthEdgeMaterialForDetail(detail);
            }
        }
        return map;
    }

    public Map<EdgeType,Double> getLengthEdgeMaterialForDetail(Detail detail) {
        Map<EdgeType, Double> map = new HashMap<>();
        map = getButtClose(detail.getX(), detail.getY(), detail.getEdgeMaterial());
        return map;
    }

    private Map<EdgeType,Double> getButtClose(int x, int y, List<EdgeMaterial> edgeMaterials) {
       Map<EdgeType, Double> map = new HashMap<>();
        if(Objects.nonNull(edgeMaterials)) {
            for (EdgeMaterial material : edgeMaterials) {
                map.put(material.getEdgeType(),getlength(x, y, material));
            }
        }
        return map;
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
