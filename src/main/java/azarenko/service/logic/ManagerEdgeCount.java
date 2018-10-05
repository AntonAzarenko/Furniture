package azarenko.service.logic;

import azarenko.entity.Detail;
import azarenko.entity.Module;
import org.springframework.stereotype.Component;

@Component
public class ManagerEdgeCount {

    public double getLengthEdgeMaterialForModule(Module module) {
        return 0d;
    }

    public double getLengthEdgeMaterialForDetail(Detail detail) {
        return 0d;
    }
}
