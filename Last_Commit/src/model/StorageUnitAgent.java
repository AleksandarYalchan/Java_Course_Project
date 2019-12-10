package model;

import javax.persistence.*;

@Entity
@Table(name="agents")
public class StorageUnitAgent extends User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_agent")
    private Integer idAgent;
    @Column(name="charging_fee")
    private double chargingFee;
    @Column(name="rating")
    private double rating;
    public StorageUnitAgent(){

    }
    public StorageUnitAgent(String userName,String password,String firstName,String lastName,Double chargingFee){
        super(userName,password,firstName,lastName);
        this.chargingFee=chargingFee;
    }
    public double getChargingFee() {

        return chargingFee;
    }

    public void setChargingFee(double chargingFee) {
        this.chargingFee = chargingFee;
    }

    public double getRating()
    {
        return rating;
    }

    public void setRating(double rating) {

        this.rating = rating;
    }

    public Integer getIdAgent() {
        return idAgent;
    }
}
