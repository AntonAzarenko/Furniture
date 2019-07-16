package azarenka.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
    private Date dateOfCreate = new Date();

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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setDateOfContract(LocalDateTime dateOfContract) {
        this.dateOfContract = dateOfContract;
    }

    public void setDateOfCreate(Date dateOfCreate) {
        this.dateOfCreate = dateOfCreate;
    }

    public Date getDateOfCreate() {
        return dateOfCreate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Order order = (Order) o;

        return new EqualsBuilder()
            .appendSuper(super.equals(o))
            .append(name, order.name)
            .append(author, order.author)
            .append(moduleList, order.moduleList)
            .append(address, order.address)
            .append(customersName, order.customersName)
            .append(telNumber, order.telNumber)
            .append(userName, order.userName)
            .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
            .appendSuper(super.hashCode())
            .append(name)
            .append(author)
            .append(moduleList)
            .append(address)
            .append(customersName)
            .append(telNumber)
            .append(userName)
            .toHashCode();
    }
}
