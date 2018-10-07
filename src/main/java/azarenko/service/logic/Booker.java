package azarenko.service.logic;

import azarenko.entity.Detail;
import azarenko.entity.Module;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class Booker {

    public BigDecimal getPriceMaterial(Detail detail) {
        return detail.getColorMaterial().getPrice();
    }

    public BigDecimal getPriceModule(Module module) {
        return null;
    }


}
