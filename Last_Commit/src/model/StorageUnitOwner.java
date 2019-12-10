package model;

import javax.persistence.*;

@Entity
@Table(name="owners")
public class StorageUnitOwner extends User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_owner")
    private Integer idOwner;

    public StorageUnitOwner(){

    }
    public StorageUnitOwner(String userName,String password,String firstName,String lastName){
        super(userName,password,firstName,lastName);
    }

    public Integer getIdOwner() {
        return idOwner;
    }

}
