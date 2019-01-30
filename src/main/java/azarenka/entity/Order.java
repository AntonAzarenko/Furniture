package azarenka.entity;

import azarenka.util.DateTimeUtil;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "author")
    private String author;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Module> moduleList;

    @Column(name = "address")
    private String address;

    @Column(name = "customer_name")
    private String customersName;

    @Column(name = "tel_number")
    private String telNumber;

    @Column(name = "date_of_contract")
    private LocalDateTime dateOfContract;

    @Column(name = "date_of_create", columnDefinition = "timestamp default now()")
    private LocalDateTime dateOfCreate;

    @Column(name="user_name")
    private String userName;

    public Order() {
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<Module> getModuleList() {
        return moduleList;
    }

    public void setModuleList(List<Module> moduleList) {
        this.moduleList = moduleList;
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

    public LocalDateTime getDateOfContract() {
        return dateOfContract;
    }

    public void setDateOfContract(LocalDateTime dateOfContract) {
        this.dateOfContract = LocalDateTime.parse(DateTimeUtil.toString(dateOfContract));
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public LocalDateTime getDateOfCreate() {
        return dateOfCreate;
    }

    public void setDateOfCreate(LocalDateTime dateOfCreate) {
        this.dateOfCreate = dateOfCreate;
    }
}
