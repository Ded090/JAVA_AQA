package org.example.task6;

import org.example.task6.Entity.Address;
import org.example.task6.Entity.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    static SessionFactory sessionFactory;

    public static void main(String[] args){
        sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        Address address = new Address();
        address.setCity("San Francisco");
        address.setZip("94107");
        address.setState("CA");
        Person person = new Person("Alice", 25, address);


        session.beginTransaction();

        session.save(address);
        Long id = (Long) session.save(person);

        Person person1 = session.get(Person.class, id);
        System.out.println(person1.getName());
        person1.setName("Mike");

        session.saveOrUpdate(person1);
        Person person2 = session.get(Person.class, id);

        System.out.println(person2.getName());

        session.delete(person2);

        Person person3 = session.get(Person.class, id);
        System.out.println(person3);


        session.getTransaction().commit();


        session.close();
        sessionFactory.close();

    }
}
