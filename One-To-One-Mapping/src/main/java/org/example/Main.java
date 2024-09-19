package org.example;

import org.example.config.FactoryConfiguration;
import org.example.entity.Address;
import org.example.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {
        Address address = new Address();
        address.setAid(1);
        address.setNumber("54/c");
        address.setStreet("Suhada Rd");
        address.setCity("Mahawila");


        Student student = new Student();
        student.setId(1);
        student.setName("Harsha");
        student.setAge(25);
        student.setAddress(address);

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(address);
        session.save(student);
        transaction.commit();
        session.close();



    }
}