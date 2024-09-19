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
        /*Address address1 = new Address();
        address1.setAid(1);
        address1.setNumber("223");
        address1.setStreet("Main Street");
        address1.setCity("Panadura");

        Address address2 = new Address();
        address2.setAid(2);
        address2.setNumber("54");
        address2.setStreet("Cemetry Street");
        address2.setCity("Bandargama");


        List<Address> addresses = new ArrayList<Address>();
        addresses.add(address1);
        addresses.add(address2);

        Student student1 = new Student();
        student1.setId(1);
        student1.setName("Harsha");
        student1.setAge(25);

        address1.setStudent(student1);
        address2.setStudent(student1);*/

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Student student = session.get(Student.class, 1);
        System.out.println(student.getAddresses());
        System.out.println(student.getId());

       /* session.save(address1);
        session.save(address2);
        session.save(student1);*/
        transaction.commit();
        session.close();



    }
}