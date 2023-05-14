package org.example.task6.task7.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "persons")
@PersistenceContext
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="age")
    private int age;

    @OneToOne
    private Address address;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Device> devices;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "person_visited_countries",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "country_id"))
    private List<Country> visitedCountries;

    public List<Country> getVisitedCountries() {
        return visitedCountries;
    }

    public void setVisitedCountries(List<Country> visitedCountries) {
        this.visitedCountries = visitedCountries;
    }

    public List<Device> getDevices() {
        return devices;
    }

    public void setDevices(List<Device> devices) {
        this.devices = devices;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
