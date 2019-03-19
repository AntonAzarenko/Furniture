package azarenka.service.logic.bookers;

import azarenka.dto.BookerDTO;
import azarenka.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static java.math.BigInteger.ZERO;

@Service
public class Booker {

    @Autowired
    private ManagerQuadCount managerQuadCount;

    @Autowired
    private ManagerEdgeCount managerEdgeCount;

    public BigDecimal getPriceModule(Module module) {
        BigDecimal price = new BigDecimal(ZERO);
        if (Objects.nonNull(module)) {
            List<Detail> list = module.getDetailList();
            Map<BigDecimal, Double> priceDetail = getPriceDetail(list);
            Map<BigDecimal, Double> priceEdge = getPriceEdge(list);

            price = price.add(getPriceForDetailMap(priceDetail));

            price = price.add(getPriceForEdgeMap(priceEdge));

            price = price.add(getPriceModuleFitting(module));
            //TODO for furniture and facadeList
        }
        return price;
    }

    public BigDecimal getTotalPriceOfOrder(List<BookerDTO> bookerList){
        BigDecimal price = new BigDecimal(ZERO);
        for(BookerDTO current: bookerList){
            price = price.add(current.getTotal());
        }
        return price;
    }

    public BigDecimal getPriceModuleFitting(Module module) {
        BigDecimal price = new BigDecimal(ZERO);
        if (module.getFittings() != null) {
            Map<BigDecimal, Integer> map = new HashMap<>();
            List<Fittings> fittings = module.getFittings();
            for(Fittings current : fittings){
                map.put(current.getPrice(), current.getCount());
            }
            price = getPriceOfFittingModule(map);
        }
        return price;
    }

    public BigDecimal getPriceDetailByType(Module module, Material material) {
        BigDecimal price = new BigDecimal(ZERO);
        if (Objects.nonNull(module)) {
            List<Detail> list = module.getDetailList();
            Map<Material, Map<BigDecimal, Double>> materialMap = managerQuadCount.getSquareDetails(list);
            for (Map.Entry<Material, Map<BigDecimal, Double>> pair : materialMap.entrySet()) {
                if (pair.getKey().equals(material)) {
                    price = getPriceForDetailMap(pair.getValue());
                    break;
                }
            }
        }
        return price;
    }

    public BigDecimal getPriceEdgeByModule(Module module) {
        BigDecimal price;
        List<Detail> details = module.getDetailList();
        Map<BigDecimal, Double> priceEdge = getPriceEdge(details);
        price = getPriceForEdgeMap(priceEdge);
        return price;
    }

    public BigDecimal getPriceOrder(Order order) {
        BigDecimal price = new BigDecimal(ZERO);
        if (Objects.nonNull(order)) {
            if (Objects.nonNull(order.getModuleList())) {
                for (Module module : order.getModuleList()) {
                    price = price.add(getPriceModule(module));
                }
            }
        }
        return price;
    }

    private BigDecimal getPriceOfFittingModule(Map<BigDecimal, Integer> map){
        BigDecimal decimal = new BigDecimal(ZERO);
        for(Map.Entry<BigDecimal, Integer> pair : map.entrySet()){
            BigDecimal tempOme = new BigDecimal(pair.getValue());
            decimal = decimal.add(tempOme.multiply(pair.getKey()));
        }
        return decimal;
    }

    private BigDecimal getPriceForDetailMap(Map<BigDecimal, Double> map) {
        BigDecimal price = new BigDecimal(ZERO);

        for (Map.Entry<BigDecimal, Double> pair : map.entrySet()) {
            BigDecimal temp = new BigDecimal(pair.getValue());
            price = price.add(new BigDecimal(String.valueOf(pair.getKey().multiply(temp))));
        }
        return price;
    }

    private BigDecimal getPriceForEdgeMap(Map<BigDecimal, Double> map) {
        BigDecimal price = new BigDecimal(ZERO);
        if (Objects.nonNull(map)) {
            for (Map.Entry<BigDecimal, Double> pair : map.entrySet()) {
                int ONE_HUNDRED_PERCENT = 100;
                int ONE_THOUSAND_MM = 1000;
                int COUNT_PERCENT = 10;
                BigDecimal temp = new BigDecimal((pair.getValue() + (pair.getValue() / ONE_HUNDRED_PERCENT * COUNT_PERCENT)) / ONE_THOUSAND_MM);
                price = price.add(new BigDecimal(String.valueOf(pair.getKey().multiply(temp))));
            }
        }
        return price;
    }

    private Map<BigDecimal, Double> getPriceDetail(List<Detail> list) {
        return managerQuadCount.getCountSquareDetailsList(list);
    }

    private Map<BigDecimal, Double> getPriceEdge(List<Detail> object) {
        return managerEdgeCount.getLengthEdgeMaterialForDetailList(object);
    }
}
