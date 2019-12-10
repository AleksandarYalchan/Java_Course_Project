package model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="contracts")
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_contract")
    private Integer idContract;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_unit")
    private StorageUnit storageUnit;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_agent")
    private StorageUnitAgent agent;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_tenant")
    private Tenant tenant;
    @Column(name="date_from")
    private Date dateFrom;
    @Column(name="date_until")
    private Date dateUntil;
    @Column(name="price")
    private double rentPrice;

    public Contract(){

    }
    public Contract(StorageUnit storageUnit, StorageUnitAgent agent, Tenant tenant, Date dateFrom, Date dateUntil, double rentPrice) {
        this.storageUnit = storageUnit;
        this.agent = agent;
        this.tenant = tenant;
        this.dateFrom = dateFrom;
        this.dateUntil = dateUntil;
        this.rentPrice = rentPrice;
    }
}
