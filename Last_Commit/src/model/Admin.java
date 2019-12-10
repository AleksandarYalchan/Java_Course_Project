package model;

import javax.persistence.*;

@Entity
@Table(name="admins")
public class Admin extends User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_admin")
    private Integer idAdmin;
    public Admin(){

    }
    public Admin(String userName,String password,String firstName,String lastName){
        super(userName,password,firstName,lastName);
    }

}
