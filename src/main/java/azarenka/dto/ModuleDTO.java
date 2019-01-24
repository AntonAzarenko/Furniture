package azarenka.dto;

import azarenka.entity.Module;
import azarenka.entity.ModuleType;
import azarenka.entity.Order;
import org.springframework.transaction.annotation.Transactional;


public class ModuleDTO {

    private Long id;

    private String name;

    private ModuleType moduleType;

    private Long order_id;

    public ModuleDTO() {
    }

    public Module asModule(){
        Order order = new Order();
        order.setId(order_id);
        Module module = new Module();
        module.setOrder(order);
        module.setId(id);
        module.setName(name);
        module.setModuleType(moduleType);
        return module;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setModuleType(ModuleType moduleType) {
        this.moduleType = moduleType;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }
}
