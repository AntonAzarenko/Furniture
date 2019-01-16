package azarenka.entity;

import javax.persistence.*;
import java.util.Date;
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
    private Date dateOfContract;

    @Column(name = "date_of_create")
    private Date dateOfCreate;

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

}
