package azarenka.service.logic.bookers;

import azarenka.entity.Detail;
import azarenka.entity.Material;
import azarenka.entity.Module;
import azarenka.entity.Order;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.*;

@Component
public class ManagerQuadCount {

    public double getCountSquareDetail(int x, int y, int count) {
        return (((double) x / 1000) * ((double) y / 1000)) * count;
    }

    public Map<BigDecimal, Double> getCountSquareDetailsList(List<Detail> detailList) {
        Map<BigDecimal, Double> map = new HashMap<>();
        if (Objects.nonNull(detailList)) {
            for (Detail detail : detailList) {
                map.merge(detail.getDetailsColor().getPrice(), getCountSquareDetail(detail.getX(), detail.getY(), detail.getCount()), (a, b) -> a + b);
            }
        }
        return map;
    }

    protected Map<Material, Map<BigDecimal, Double>> getSquareDetails(List<Detail> details) {
        Map<Material, Map<BigDecimal, Double>> map = new HashMap<>();
        Map<Material, List<Detail>> materialListMap = sortDetailOnMaterialType(details);
        for (Map.Entry<Material, List<Detail>> pair : materialListMap.entrySet()) {
            map.put(pair.getKey(), getCountSquareDetailsList(pair.getValue()));
        }
        return map;
    }


    public Map<BigDecimal, Double> getCountSquareDetailsForModule(Module module) {
        Map<BigDecimal, Double> map = new HashMap<>();
        if (Objects.nonNull(module)) {
            List<Detail> detailList = module.getDetailList();
            if (Objects.nonNull(detailList)) {
                map = getCountSquareDetailsList(detailList);
            }
        }
        return map;
    }

    public Map<BigDecimal, Double> getCountSquareForOrder(Order order) {
        Map<BigDecimal, Double> map = new HashMap<>();
        List<Module> moduleList = order.getModuleList();
        Map<BigDecimal, Double> map2 = new HashMap<>();
        if (Objects.nonNull(moduleList)) {
            map2 = getCountSquareDetailsForModuleList(moduleList);
        }
        Map<BigDecimal, Double> mapFull = new HashMap<>(map);
        map2.forEach((k, v) -> mapFull.merge(k, v, (a, b) -> a + b));
        return mapFull;
    }

    public Map<BigDecimal, Double> getCountSquareDetailsForModuleList(List<Module> moduleList) {
        Map<BigDecimal, Double> map = new HashMap<>();
        if (Objects.nonNull(moduleList)) {
            for (Module module : moduleList) {
                map = getCountSquareDetailsForModule(module);
            }
        }
        return map;
    }

    private Map<Material, List<Detail>> sortDetailOnMaterialType(List<Detail> details) {
        Map<Material, List<Detail>> map = new HashMap<>();
        List<Detail> listDsp = new ArrayList<>();
        List<Detail> listDvp = new ArrayList<>();
        List<Detail> listMDF = new ArrayList<>();
        List<Detail> listWOOD = new ArrayList<>();
        for (Detail current : details) {
            if (current.getMaterial().equals(Material.DSP)) {
                listDsp.add(current);
            } else if (current.getMaterial().equals(Material.DVP)) {
                listDvp.add(current);
            } else if (current.getMaterial().equals(Material.MDF) || current.getMaterial().equals("WOOD")) {
                listMDF.add(current);
            } else if (current.getMaterial().equals(Material.WOOD)) {
                listDsp.add(current);
            }
        }
        map.put(Material.DSP, listDsp);
        map.put(Material.DVP, listDvp);
        map.put(Material.MDF, listMDF);
        map.put(Material.WOOD, listWOOD);
        return map;
    }
}
