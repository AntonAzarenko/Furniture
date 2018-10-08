package azarenko.service.logic;

import azarenko.entity.Detail;
import azarenko.entity.EdgeMaterial;
import azarenko.entity.Module;

import azarenko.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class Booker {

    @Autowired
    private ManagerQuadCount managerQuadCount;

    @Autowired
    private ManagerEdgeCount managerEdgeCount;

    public BigDecimal getPriceModule(Module module) {
        BigDecimal price = new BigDecimal(0);
        if (Objects.nonNull(module)) {
            List<Detail> list = module.getDetailList();

            Map<BigDecimal, Double> priceDetail = getPriceDetail(list);
            Map<BigDecimal, Double> priceEdge = getPriceEdge(list);

            price = price.add(getPriceForDetailMap(priceDetail));
            price = price.add(getPriceForEdgeMap(priceEdge));

            //TODO for furniture and facadeList
        }
        return price;
    }

    public BigDecimal getPriceOrder(Order order) {
        BigDecimal price = new BigDecimal(0);
        if (Objects.nonNull(order)) {
            for (Module module : order.getModuleList()) {
                price = price.add(getPriceModule(module));
            }
            price = price.add(getPriceForDetailMap(getPriceDetail(order.getDetailList())));

        }

        return price;
    }

    private BigDecimal getPriceForDetailMap(Map<BigDecimal, Double> map) {
        BigDecimal price = new BigDecimal(0);

        for (Map.Entry<BigDecimal, Double> pair : map.entrySet()) {
            BigDecimal temp = new BigDecimal(pair.getValue());
            price = price.add(new BigDecimal(String.valueOf(pair.getKey().multiply(temp))));
        }
        return price;
    }

    private BigDecimal getPriceForEdgeMap(Map<BigDecimal, Double> map) {
        BigDecimal price = new BigDecimal(0);

        for (Map.Entry<BigDecimal, Double> pair : map.entrySet()) {
            BigDecimal temp = new BigDecimal((pair.getValue() + (pair.getValue() / 100 * 10))/1000);
            price = price.add(new BigDecimal(String.valueOf(pair.getKey().multiply(temp))));
        }
        return price;
    }

    private Map<BigDecimal, Double> getPriceDetail(Object object) {
        return managerQuadCount.getCountSquareDetailsList((List<Detail>) object);
    }

    private Map<BigDecimal, Double> getPriceEdge(Object object) {
        return managerEdgeCount.getLengthEdgeMaterialForDetailList((List<Detail>) object);
    }
}
