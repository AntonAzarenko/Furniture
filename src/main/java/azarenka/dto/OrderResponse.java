package azarenka.dto;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import azarenka.entity.Order;
import azarenka.util.DateTimeUtil;

import java.util.Date;

public class OrderResponse {

    private Long id;
    private String name;
    private String address;
    private String customersName;
    private String telNumber;
    private String dateOfContract;
    private String dateOfCreate;
    private String userName;

    public OrderResponse() {
    }

    public Order asOrder() {
        Order order = new Order();
        order.setId(this.id);
        order.setName(this.name);
        order.setCustomersName(this.customersName);
        order.setAddress(this.address);
        order.setAuthor("somebody");//todo
        order.setTelNumber(this.telNumber);
        order.setDateOfCreate(new Date());
        order.setUserName(this.userName);
        return order;
    }

    public static OrderResponse asOrderDTO(Order order) {
        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setId(order.getId());
        orderResponse.setName(order.getName());
        orderResponse.setAddress(order.getAddress());
        orderResponse.setTelNumber(order.getTelNumber());
        orderResponse.setCustomersName(order.getCustomersName());
        orderResponse.setDateOfCreate(DateTimeUtil.toString(order.getDateOfCreate()));
        orderResponse.setDateOfContract(DateTimeUtil.toString(order.getDateOfContract()));
        return orderResponse;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        OrderResponse that = (OrderResponse) o;

        return new EqualsBuilder()
            .append(id, that.id)
            .append(name, that.name)
            .append(address, that.address)
            .append(customersName, that.customersName)
            .append(telNumber, that.telNumber)
            .append(userName, that.userName)
            .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
            .append(id)
            .append(name)
            .append(address)
            .append(customersName)
            .append(telNumber)
            .append(userName)
            .toHashCode();
    }
}
