package org.example.task6.Entity;


import javax.persistence.*;

@Entity
@Table(name = "addresses")
@PersistenceContext
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="city")
    private String city;

    @Column(name="zip")
    private String zip;

    @Column(name="state")
    private String state;

    public Address(String city, String zip, String state){
        this.city = city;
        this.zip = zip;
        this.state = state;
    }

    public Address() {}

    public String toString(){
        return "City: " + city + ", State: " + state + ", Zip: " + zip;
    }

    public Long getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
