package org.example.task6.task7.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "countries")
@PersistenceContext
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;

    @ManyToMany(mappedBy = "visitedCountries", fetch = FetchType.LAZY)
    private List<Person> persons;

    public Country(String name) {
        this.name = name;
    }

    public Country() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
