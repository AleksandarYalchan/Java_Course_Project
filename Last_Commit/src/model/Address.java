package model;

import javax.persistence.*;

@Entity
@Table(name="addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_address")
    private Integer idAddress;
    @Column(name="country")
    private String country;
    @Column(name="city")
    private String city;
    @Column(name="street")
    private String street;
    @Column(name="№")
    private int streetNum;
    @Column(name="post_code")
    private String postCode;

    public Address(){

    }
    public Address(String country, String city, String street,int streetNum, String postCode) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.streetNum=streetNum;
        this.postCode = postCode;
    }

    public Integer getIdAddress() {
        return idAddress;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getPostCode() {
        return postCode;
    }

    public int getStreetNum() {
        return streetNum;
    }

    @Override
    public String toString() {
        return  country +" " +city + ' ' + street + ' ' +' '+streetNum+' '+ postCode;
    }
}
