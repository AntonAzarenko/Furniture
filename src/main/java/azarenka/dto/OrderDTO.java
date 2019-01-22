package azarenka.dto;

import azarenka.entity.Module;
import azarenka.entity.Order;
import azarenka.util.DateTimeUtil;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.List;

public class OrderDTO {

    private Long id;

    private String name;

    private String address;

    private String customersName;

    private String telNumber;

    private String dateOfContract;

    private String dateOfCreate;

    public OrderDTO() {
    }

    public Order asOrder(){
        Order order = new Order();
        return order;
    }

    public  static OrderDTO asOrderDTO(Order order){
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(order.getId());
        orderDTO.setName(order.getName());
        orderDTO.setAddress(order.getAddress());
        orderDTO.setTelNumber(order.getTelNumber());
        orderDTO.setCustomersName(order.getCustomersName());
        orderDTO.setDateOfCreate(DateTimeUtil.toString(order.getDateOfCreate()));
        orderDTO.setDateOfContract(DateTimeUtil.toString(order.getDateOfContract()));
        return orderDTO;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCustomersName() {
        return customersName;
    }

    public void setCustomersName(String customersName) {
        this.customersName = customersName;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public String getDateOfContract() {
        return dateOfContract;
    }

    public void setDateOfContract(String dateOfContract) {
        this.dateOfContract = dateOfContract;
    }

    public String getDateOfCreate() {
        return dateOfCreate;
    }

    public void setDateOfCreate(String dateOfCreate) {
        this.dateOfCreate = dateOfCreate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
