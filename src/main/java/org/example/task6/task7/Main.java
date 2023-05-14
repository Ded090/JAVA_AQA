package org.example.task6.task7;

import org.example.task4.C;
import org.example.task6.task7.Entity.Address;
import org.example.task6.task7.Entity.Country;
import org.example.task6.task7.Entity.Person;
import org.example.task6.task7.Entity.Device;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class Main {

    static SessionFactory sessionFactory;

    public static void main(String[] args){
        sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        session.beginTransaction();
        // one to one
        Address address = new Address();
        address.setCity("San Francisco");
        address.setZip("94107");
        address.setState("CA");
        Person person = new Person("Alice", 25);

        person.setAddress(address);
        // one to many
        Device device = new Device("iPhone 14", "87JG67GHHLY886TGHJ6RT7H89");
        Device device1 = new Device("iPhone 14 pro max", "H8G775BFB567BB88B7J89JY7");

        List<Device> deviceList = new ArrayList<>();
        deviceList.add(device);
        deviceList.add(device1);

        person.setDevices(deviceList);

        //many to many
        Country usa = new Country("United States of America");
        Country it = new Country("Italy");
        Country uk = new Country("United Kingdom");
        Country ua = new Country("Ukraine");

        List<Country> visitedCountries = new ArrayList<>();
        visitedCountries.add(usa);
        visitedCountries.add(ua);
        visitedCountries.add(it);
        visitedCountries.add(uk);

        person.setVisitedCountries(visitedCountries);
        session.save(person);


//
        session.save(usa);
        session.save(it);
        session.save(uk);
        session.save(ua);
        session.save(device);
        session.save(device1);
        session.save(address);

//
        session.getTransaction().commit();


        session.close();
        sessionFactory.close();

    }
}
