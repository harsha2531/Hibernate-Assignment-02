package org.example;

import org.example.config.FactoryConfiguration;
import org.example.entity.Address;
import org.example.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Address address1 = new Address();
        address1.setAid(1);
        address1.setNumber("100");
        address1.setStreet("Street 1");
        address1.setCity("City 1");

        Address address2 = new Address();
        address2.setAid(2);
        address2.setNumber("200");
        address2.setStreet("Street 2");
        address2.setCity("City 2");

        Student student1 = new Student();
        student1.setId(1);
        student1.setName("John Doe");
        student1.setAge(20);

        Student student2 = new Student();
        student2.setId(2);
        student2.setName("Michael Smith");
        student2.setAge(40);

        List<Address> addresses = new ArrayList<Address>();
        addresses.add(address1);
        addresses.add(address2);

        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);

        student1.setAddresses(addresses);
        student2.setAddresses(addresses);

        address1.setStudents(students);
        address2.setStudents(students);

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(address1);
        session.save(address2);
        session.save(student1);
        session.save(student2);
        transaction.commit();
        session.close();


    }
}