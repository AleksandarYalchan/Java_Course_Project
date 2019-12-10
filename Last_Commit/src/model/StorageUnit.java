package model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "storage_units")
public class StorageUnit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_unit")
    private Integer id_unit;

    @Column(name = "name")
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_address")
    private Address address;
    @Column(name = "size")
    private int size;
    @Column(name = "category")
    private String category;
    @Column(name = "climate_conditions")
    private String climateConditions;
    @Column(name = "content")
    private String content;
    @Column(name = "price")
    private double price;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_owner")
    private StorageUnitOwner owner;
    @Column(name = "is_rented")
    private Boolean isRented;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "unit_agent_mapping", joinColumns = @JoinColumn(name = "id_unit"),
            inverseJoinColumns = @JoinColumn(name = "id_agent"))
    private Set<StorageUnitAgent> agent = new HashSet<>();

    public StorageUnit() {

    }

    public StorageUnit(String name, Address address, int size, String category, String climateConditions,
                       String content, double price, StorageUnitOwner owner) {
        this.name = name;
        this.address = address;
        this.size = size;
        this.category = category;
        this.climateConditions = climateConditions;
        this.content = content;
        this.price = price;
        this.owner = owner;
        this.isRented = false;
    }


    public StorageUnitOwner getOwner() {
        return owner;
    }

    public Integer getId_unit() {
        return id_unit;

    }

    public String getName() {
        return name;

    }

    public Address getAddress() {
        return address;

    }

    public int getSize() {
        return size;

    }

    public String getCategory() {
        return category;

    }

    public String getClimateConditions() {
        return climateConditions;

    }

    public String getContent() {
        return content;

    }

    public double getPrice() {
        return price;

    }

    public Set<StorageUnitAgent> getAgent() {
        return agent;

    }

    public Boolean isRented() {
        return isRented;
    }

    public void setRented(Boolean rented) {
        isRented = rented;
    }

    @Override
    public String toString() {
        return "StorageUnit{" +
                "name='" + name + '\'' +
                ", address=" + address +
                ", size=" + size +
                ", category='" + category + '\'' +
                ", climateConditions='" + climateConditions + '\'' +
                ", content='" + content + '\'' +
                ", price=" + price +
                '}';
    }
}
