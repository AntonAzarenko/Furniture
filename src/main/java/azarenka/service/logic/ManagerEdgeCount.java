package azarenka.service.logic;

import azarenka.entity.Detail;
import azarenka.entity.EdgeMaterial;
import azarenka.entity.Module;
import azarenka.entity.Order;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;


@Component
public class ManagerEdgeCount {

    private Map<BigDecimal, Double> map = new HashMap<>();

    public Map<BigDecimal, Double> getLengthEdgeMaterialForOrder(Order order) {
        List<Module> moduleList = order.getModuleList();
        List<Detail> detailList = order.getDetailList();
        if (Objects.nonNull(moduleList)) {
            for (Module module : moduleList) {
                map = getLengthEdgeMaterialForModule(module);
            }
        }

        Map<BigDecimal, Double> map2 = new HashMap<>();
        if (Objects.nonNull(detailList)) { //TODO this block is not covered by the tests
            for (Detail detail : detailList) {
                map2 = (getLengthEdgeMaterialForDetail(detail));
            }
        }

        Map<BigDecimal, Double> mapFull = new HashMap<>(map);
        map2.forEach((k, v) -> mapFull.merge(k, v, (a, b) -> a + b));
        return mapFull;
    }

    public Map<BigDecimal, Double> getLengthEdgeMaterialForModule(Module module) {
        return getLengthEdgeMaterialForDetailList(module.getDetailList());
    }

    public Map<BigDecimal, Double> getLengthEdgeMaterialForDetailList(List<Detail> detailList) {
        if (Objects.nonNull(detailList)) {
            for (Detail detail : detailList) {
                map = getLengthEdgeMaterialForDetail(detail);
            }
        }
        return map;
    }

    public Map<BigDecimal, Double> getLengthEdgeMaterialForDetail(Detail detail) {
        return getButtClose(detail.getX(), detail.getY(), detail.getEdgeMaterial(), detail.getCount());
    }

    private Map<BigDecimal, Double> getButtClose(int x, int y, List<EdgeMaterial> edgeMaterials, int count) {
        if (Objects.nonNull(edgeMaterials)) {
            for (EdgeMaterial material : edgeMaterials) {
                map.merge(material.getPrice(), getlength(x, y, material, count), (oldValue, newValue) -> oldValue + newValue);
            }
        }
        return map;
    }

    private double getlength(int x, int y, EdgeMaterial material, int count) {
        switch (material.getButtCloses()) { // TODO not all cases covered by the tests
            case BUTT_X:
                return (double) x * count;
            case BUTT_Y:
                return (double) y * count;
            case BUTT_DOUBLE_X:
                return (double) x * 2 * count;
            case BUTT_DOUBLE_Y:
                return (double) y * 2 * count;
            case BUTT_X_AND_Y:
                return (double) x + y * count;
            case BUTT_ARROUND:
                return (double) x * 2 + y * 2 * count;
            case BUTT_DOUBLE_X_AND_Y:
                return (double) x * 2 + y * count;
            case BUTT_DOUBLE_Y_AND_X:
                return (double) y * 2 + x * count;
        }
        return 0d;
    }
}
