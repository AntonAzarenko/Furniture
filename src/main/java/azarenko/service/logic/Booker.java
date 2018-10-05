package azarenko.service.logic;

import azarenko.entity.Detail;
import azarenko.entity.Module;
import azarenko.entity.Order;
import azarenko.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

@Component
public class Booker {

    public BigDecimal getPriceMaterial(Detail detail) {
        return detail.getColorMaterial().getPrice();
    }

    public BigDecimal getPriceModule(Module module) {
        return null;
    }


}
