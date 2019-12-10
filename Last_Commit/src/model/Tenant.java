package model;

import javax.persistence.*;

@Entity
@Table(name="tenants")
public class Tenant extends Person {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_tenant")
    private Integer id_tenant;
    public Tenant(){

    }
    public Tenant(String firstName,String lastName){
        super(firstName,lastName);
    }

    public Integer getId_tenant() {
        return id_tenant;
    }
}
