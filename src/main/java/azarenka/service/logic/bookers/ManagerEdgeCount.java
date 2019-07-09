package azarenka.service.logic.bookers;

import azarenka.entity.Detail;
import azarenka.entity.EdgeMaterial;
import azarenka.entity.Module;
import azarenka.entity.Order;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.*;

@Component
public class ManagerEdgeCount {

    public Map<BigDecimal, Double> getLengthEdgeMaterialForOrder(Order order) {
        Map<BigDecimal, Double> map = new HashMap<>();
        List<Module> moduleList = order.getModuleList();
        List<Detail> detailList = new ArrayList<>();
        if (Objects.nonNull(moduleList)) {
            for (Module module : moduleList) {
                map = getLengthEdgeMaterialForModule(module);
            }
        }

        Map<BigDecimal, Double> map2 = new HashMap<>();
        //TODO this block is not covered by the tests
        for (Detail detail : detailList) {
            map2 = (getLengthEdgeMaterialForDetail(detail));
        }

        Map<BigDecimal, Double> mapFull = new HashMap<>(map);
        map2.forEach((k, v) -> mapFull.merge(k, v, (a, b) -> a + b));
        return mapFull;
    }

    public Map<BigDecimal, Double> getLengthEdgeMaterialForModule(Module module) {
        return getLengthEdgeMaterialForDetailList(module.getDetailList());
    }

    public Map<BigDecimal, Double> getLengthEdgeMaterialForDetailList(List<Detail> detailList) {
        Map<BigDecimal, Double> mapFull = new HashMap<>();
        if (Objects.nonNull(detailList)) {
            for (Detail detail : detailList) {
                Map<BigDecimal, Double> map =  getLengthEdgeMaterialForDetail(detail);
               map.forEach((k,v) ->mapFull.merge(k, v, (a, b) -> a + b));
            }
        }
        return mapFull;
    }

    public Map<BigDecimal, Double> getLengthEdgeMaterialForDetail(Detail detail) {
        return getButtClose(detail.getX(), detail.getY(), detail.getEdgeMaterial(), detail.getCount());
    }

    private Map<BigDecimal, Double> getButtClose(int x, int y, Set<EdgeMaterial> edgeMaterials, int count) {
        Map<BigDecimal, Double> map = new HashMap<>();
        if (Objects.nonNull(edgeMaterials)) {
            for (EdgeMaterial material : edgeMaterials) {
                map.merge(material.getEdge().getPrice(), getLength(x, y, material, count), (oldValue, newValue) -> oldValue + newValue);
            }
        }
        return map;
    }

    private double getLength(int x, int y, EdgeMaterial material, int count) {
        switch (material.getEdgeSide()) {
            case SIDE_X:
                return (double) x * count;
            case SIDE_Y:
                return (double) y * count;
            case SIDE_DOUBLE_X:
                return (double) x * 2 * count;
            case SIDE_DOUBLE_Y:
                return (double) y * 2 * count;
            case SIDE_X_AND_Y:
                return (double) x + y * count;
            case SIDE_AROUND:
                return (double) ((x * 2) + (y * 2)) * count;
            case SIDE_DOUBLE_X_AND_Y:
                return (double) x * 2 + y * count;
            case SIDE_DOUBLE_Y_AND_X:
                return (double) y * 2 + x * count;
        }
        return 0d;
    }
}
